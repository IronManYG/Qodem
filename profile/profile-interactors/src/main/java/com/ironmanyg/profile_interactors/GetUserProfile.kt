package com.ironmanyg.profile_interactors

import com.ironmanyg.core.domain.DataState
import com.ironmanyg.core.domain.ProgressBarState
import com.ironmanyg.core.util.Logger
import com.ironmanyg.profile_datasource.network.ProfileService
import com.ironmanyg.profile_domain.user.User
import com.ironmanyg.profile_interactors.util.handleExceptions
import com.ironmanyg.profile_interactors.util.retryIO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * A use-case class responsible for fetching the user profile data.
 *
 * It leverages the [ProfileService] to fetch the data and informs the UI about the loading state, data state and handles errors gracefully, logging them via the [Logger] instance.
 *
 * @param service The service used to perform network operations to fetch data.
 * @param logger A logger utility to log error messages potentially to services like Crashlytics.
 */
class GetUserProfile(
    private val service: ProfileService,
    private val logger: Logger,
) {

    companion object {
        private const val RETRY_COUNT = 3
        private const val RETRY_DELAY_MILLIS = 1000L
    }

    /**
     * Fetches a [User] entity by making a network call through the [service].
     * It includes a retry mechanism that attempts to fetch the data [RETRY_COUNT] times before giving up,
     * in order to deal with transient network failures.
     *
     * This method leverages Kotlin's Flow API to emit states representing loading, success, and error states, providing a responsive UI experience.
     *
     * @return A flow of [DataState] objects representing various states of the fetching operation.
     */
    fun execute(userId: String): Flow<DataState<User>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val userProfile = try {
                retryIO(
                    count = RETRY_COUNT,
                    delayMillis = RETRY_DELAY_MILLIS
                ) { service.getProfile(userId) }
            } catch (exception: Exception) {
                handleExceptions(exception, logger)
                null
            }

            emit(DataState.Data(userProfile))
        } catch (exception: Exception) {
            handleExceptions(exception, logger)
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}