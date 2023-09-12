package com.ironmanyg.blood_donation_interactors.bloodDonationCenters

import com.ironmanyg.blood_donation_datasource.network.BloodDonationService
import com.ironmanyg.blood_donation_domain.donationCenter.DonationCenter
import com.ironmanyg.core.domain.DataState
import com.ironmanyg.core.domain.ProgressBarState
import com.ironmanyg.core.domain.UIComponent
import com.ironmanyg.core.util.Logger
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException
import java.io.IOException

/**
 * A use-case class responsible for fetching the list of blood donation centers.
 *
 * It leverages the [BloodDonationService] to fetch the data and informs the UI about the loading state, data state and handles errors gracefully, logging them via the [Logger] instance.
 *
 * @param service The service used to perform network operations to fetch data.
 * @param logger A logger utility to log error messages potentially to services like Crashlytics.
 */
class GetBloodDonationCenters(
    //private val cache: BloodDonationCache, // TODO(Add cache implementation)
    private val service: BloodDonationService,
    private val logger: Logger // in case of production, we can use this logger to log the errors to crashlytics or else
) {

    companion object {
        private const val RETRY_COUNT = 3
        private const val RETRY_DELAY_MILLIS = 1000L
    }

    /**
     * Fetches a list of [DonationCenter] entities by making a network call through the [service].
     * It includes a retry mechanism that attempts to fetch the data [RETRY_COUNT] times before giving up,
     * in order to deal with transient network failures.
     *
     * This method leverages Kotlin's Flow API to emit states representing loading, success, and error states, providing a responsive UI experience.
     *
     * @return A flow of [DataState] objects representing various states of the fetching operation.
     */
    fun execute(): Flow<DataState<List<DonationCenter>>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            delay(1000)

            // the reason of add this second try catch within over all try catch is to catch the network exception.
            // and there is a network exception, it will not filed completely we can return the cached data
            val donationCenters = try {
                retryIO { service.getDonationCenters() }
            } catch (e: HttpRequestTimeoutException) {
                // Handle request timeout exception
                handleNetworkException(e)
                listOf()
            } catch (e: ResponseException) {
                // Handle HTTP response exception (e.g., 4xx and 5xx HTTP statuses)
                handleHttpException(e)
                listOf()
            } catch (e: SerializationException) {
                // Handle JSON parsing exception
                handleJsonParsingException(e)
                listOf()
            } catch (e: Exception) {
                // Handle other general exceptions
                handleGeneralException(e)
                listOf()
            }

            // TODO: Add cache logic here to save the data to cache
            emit(DataState.Data(donationCenters))
        } catch (e: Exception) {
            handleGeneralException(e)
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }


    private suspend fun FlowCollector<DataState<List<DonationCenter>>>.handleNetworkException(e: HttpRequestTimeoutException) {
        e.printStackTrace()
        logger.log("Network Timeout Error: ${e.message ?: "The request timed out."}")
        emit(
            DataState.Response(
                uiComponent = UIComponent.Dialog(
                    title = "Network Timeout Error",
                    description = e.message ?: "The request timed out."
                )
            )
        )
    }


    private suspend fun FlowCollector<DataState<List<DonationCenter>>>.handleHttpException(e: ResponseException) {
        e.printStackTrace()
        logger.log("HTTP Error: HTTP status ${e.response.status.value}: ${e.message}")
        emit(
            DataState.Response(
                uiComponent = UIComponent.Dialog(
                    title = "HTTP Error",
                    description = "HTTP status ${e.response.status.value}: ${e.message}"
                )
            )
        )
    }

    private suspend fun FlowCollector<DataState<List<DonationCenter>>>.handleJsonParsingException(e: SerializationException) {
        e.printStackTrace()
        logger.log("Data Parsing Error: ${e.message ?: "An error occurred while parsing the data."}")
        emit(
            DataState.Response(
                uiComponent = UIComponent.Dialog(
                    title = "Data Parsing Error",
                    description = e.message ?: "An error occurred while parsing the data."
                )
            )
        )
    }

    private suspend fun FlowCollector<DataState<List<DonationCenter>>>.handleGeneralException(e: Exception) {
        e.printStackTrace()
        logger.log("Unknown Error: ${e.message ?: "An unknown error occurred."}")
        emit(
            DataState.Response(
                uiComponent = UIComponent.Dialog(
                    title = "Unknown Error",
                    description = e.message ?: "An unknown error occurred."
                )
            )
        )
    }

    /**
     * A utility function that provides a retry mechanism for IO operations.
     * It tries to execute the given [block] up to [RETRY_COUNT] times with a delay of [RETRY_DELAY_MILLIS] milliseconds between each attempt.
     *
     * @param block The suspend function to retry.
     * @return The result of the suspend function if it succeeds within the retry limit.
     * @throws IOException if all retry attempts fail.
     */
    private suspend fun <T> retryIO(block: suspend () -> T): T {
        repeat(RETRY_COUNT) { retryCount ->
            try {
                return block()
            } catch (e: IOException) {
                if (retryCount == RETRY_COUNT - 1) throw e
                delay(RETRY_DELAY_MILLIS)
            }
        }
        throw IOException("Unexpected IO Error") // This line should be unreachable
    }
}
