package com.ironmanyg.core.domain

/**
 * A sealed class that represents the different states of data in an application.
 * DataState is a generic class that wraps around all the data returned from the use cases.
 * It acts as a data holder class that can contain data and status information, particularly
 * regarding the loading process of this data.
 *
 * @param T The type of the data.
 */
sealed class DataState<T> {
    /**
     * Represents the state when the data has been fetched, and it can be either a positive or negative response.
     * It contains a UI component that should be displayed to the user.
     *
     * @property uiComponent The UI component to be displayed based on the response state.
     */
    data class Response<T>(
        val uiComponent: UIComponent
    ) : DataState<T>()

    /**
     * Represents the state when the data has been received successfully.
     * It contains the actual data as the property `data`.
     *
     * @param data The data itself, which may be null in some cases.
     */
    data class Data<T>(
        val data: T?
    ) : DataState<T>()

    /**
     * Represents the state when the data is being fetched or processed.
     * It holds the state of the progress bar that should be displayed during loading.
     *
     * @param progressBarState The state of the progress bar to be displayed.
     */
    data class Loading<T>(
        val progressBarState: ProgressBarState = ProgressBarState.Idle
    ) : DataState<T>()
}
