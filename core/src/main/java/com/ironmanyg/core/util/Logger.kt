package com.ironmanyg.core.util

/**
 * A simple logger utility to handle logging messages during development and production.
 *
 * @param tag The tag to be used in log messages to identify the source of the logs.
 * @param isDebug Flag indicating whether the logger should print logs in debug mode or
 * suppress them in production mode. If true, logs will be printed in debug mode.
 */
class Logger(
    private val tag: String,
    private val isDebug: Boolean = true,
) {
    /**
     * Logs the given message based on the logger's configuration (debug or production mode).
     * In debug mode, the log will be printed using the provided tag and message. In production
     * mode, logs will be suppressed, and you may integrate Crashlytics or any other logging system
     * for production-level logging.
     *
     * @param msg The message to be logged.
     */
    fun log(msg: String) {
        if (isDebug) {
            printLogD(tag, msg)
        } else {
            // Production logging - You can integrate Crashlytics or other logging system here.
            // For now, it is left empty as an example.
//            sendToCrashlytics(tag, msg)
        }
    }

    /**
     * Companion object that serves as a factory for creating instances of the Logger in debug mode or production mode.
     */
    companion object Factory {
        /**
         * Builds a Logger instance for debug mode with the provided tag.
         *
         * @param className The class name or any identifier to be used as the tag in logs.
         * @return A Logger instance configured for debug mode.
         */
        fun buildDebug(className: String): Logger {
            return Logger(
                tag = className,
                isDebug = true,
            )
        }

        /**
         * Builds a Logger instance for production mode with the provided tag.
         *
         * @param className The class name or any identifier to be used as the tag in logs.
         * @return A Logger instance configured for production mode.
         */
        fun buildRelease(className: String): Logger {
            return Logger(
                tag = className,
                isDebug = false,
            )
        }
    }
}

/**
 * Prints a debug log message to the console.
 *
 * @param tag The tag to be used in the log message.
 * @param message The message to be logged.
 */
fun printLogD(tag: String?, message: String) {
    println("$tag: $message")
}

/**
 * Sends the log message to Crashlytics for production-level logging and crash reporting.
 *
 * @param tag The tag to be used in the log message.
 * @param message The message to be logged.
 */
fun sendToCrashlytics(tag: String, message: String) {
    // Send the log message to Crashlytics for production-level logging.
    //Firebase.crashlytics.log("$tag: $message")
}
