package com.ironmanyg.profile_interactors.util

import com.ironmanyg.core.domain.DataState
import com.ironmanyg.core.domain.UIComponent
import com.ironmanyg.core.util.Logger
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.serialization.SerializationException
import java.io.IOException

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

    // Define a title and choose the appropriate UIComponent based on the type of exception.
    val (title, uiComponent) = when (exception) {
        is HttpRequestTimeoutException -> "Network Timeout Error" to UIComponent.Dialog(
            title = "Network Timeout",
            description = customMessage
                ?: "The request timed out. Please check your internet connection."
        )

        is ResponseException -> "HTTP Error" to UIComponent.Notification(
            title = "Server Error",
            description = customMessage ?: "A server error occurred. Please try again later."
        )

        is SerializationException -> "Data Parsing Error" to UIComponent.SnackBar(
            message = customMessage ?: "An error occurred while parsing data."
        )

        else -> "Unknown Error" to UIComponent.Toast(
            message = customMessage ?: "An unknown error occurred."
        )
    }

    // Log the error message to the provided logger, if available.
    if (exception is ResponseException) {
        logger?.log("$title: HTTP status ${exception.response.status.value}: ${exception.message}")
    } else {
        logger?.log("$title: ${exception.message ?: "An unknown error occurred."}")
    }

    // Emit a data state with the chosen UI component to reflect the error state in the UI.
    emit(
        DataState.Response(
            uiComponent = uiComponent
        )
    )
}