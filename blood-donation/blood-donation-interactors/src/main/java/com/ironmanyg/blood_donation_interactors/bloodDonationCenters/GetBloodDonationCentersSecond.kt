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
class GetBloodDonationCentersSecond(
    private val service: BloodDonationService,
    private val logger: Logger
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

            val donationCenters = try {
                retryIO(
                    count = RETRY_COUNT,
                    delayMillis = RETRY_DELAY_MILLIS
                ) { service.getDonationCenters() }
            } catch (exception: Exception) {
                handleExceptions(exception, logger)
                listOf()
            }

            emit(DataState.Data(donationCenters))
        } catch (exception: Exception) {
            handleExceptions(exception, logger)
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }

}

/**
 * A utility function that implements a retry mechanism for IO operations, attempting to execute
 * a given [block] of code up to a specified number of [count] times with a delay of [delayMillis]
 * milliseconds between each attempt. If all attempts fail, the last encountered IOException is thrown.
 *
 * @param count The number of times to attempt to execute the block. Defaults to 3 if not specified.
 * @param delayMillis The delay in milliseconds between attempts. Defaults to 1000ms if not specified.
 * @param block The block of code to be executed with the retry mechanism.
 * @return The result of the successful execution of the block.
 * @throws IOException if all retry attempts fail.
 */
suspend fun <T> retryIO(
    count: Int = 3, // Default value specified
    delayMillis: Long = 1000L, // Default value specified
    block: suspend () -> T
): T {
    repeat(count) { retryCount ->
        try {
            return block()
        } catch (e: IOException) {
            if (retryCount == count - 1) throw e
            delay(delayMillis)
        }
    }
    // We have handled all cases inside the repeat block including throwing the exception
    // in case of failure in all retry attempts, hence this line should be unreachable.
    throw IOException("Unexpected IO Error")
}

/**
 * Extension function for [FlowCollector] to handle exceptions elegantly and emit a corresponding [DataState] with
 * the relevant error message and UI component to reflect the error state in the UI.
 *
 * This function categorizes the exception into one of the pre-defined types and emits a [DataState.Response]
 * object with a suitable error message and title. In case a custom message is provided, it will be used
 * instead of the generated message.
 *
 * @param exception The exception that occurred during a data flow operation.
 * @param logger An optional logger to which the error message can be logged. It can be null.
 * @param customMessage An optional custom message to override the default error message based on the exception type.
 */
suspend inline fun <reified T> FlowCollector<DataState<T>>.handleExceptions(
    exception: Exception,
    logger: Logger?,
    customMessage: String? = null
) {
    // Log the stack trace of the exception for debugging purposes.
    // In production, consider logging to a file or external system for better tracking.
    exception.printStackTrace()

    // Define a title based on the type of exception to give a clear context to the user.
    val title = when (exception) {
        is HttpRequestTimeoutException -> "Network Timeout Error"
        is ResponseException -> "HTTP Error"
        is SerializationException -> "Data Parsing Error"
        else -> "Unknown Error"
    }

    // Define a message based on the type of exception, providing detailed information about the error occurred.
    // If a custom message is provided, it takes precedence over the default message.
    val message = customMessage ?: when (exception) {
        is HttpRequestTimeoutException -> "Network Timeout Error: ${exception.message ?: "The request timed out."}"
        is ResponseException -> "HTTP Error: HTTP status ${exception.response.status.value}: ${exception.message}"
        is SerializationException -> "Data Parsing Error: ${exception.message ?: "An error occurred while parsing the data."}"
        else -> "Unknown Error: ${exception.message ?: "An unknown error occurred."}"
    }

    // Log the error message to the provided logger, if available.
    logger?.log(message)

    // Emit a data state with a UI component to reflect the error state in the UI with a dialog box containing the error title and message.
    emit(
        DataState.Response(
            uiComponent = UIComponent.Dialog(
                title = title,
                description = message
            )
        )
    )
}




