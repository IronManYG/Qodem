package com.ironmanyg.core.domain

/**
 * A sealed class that represents the different states of a progress bar in an application.
 * ProgressBarState is used to indicate the current state of the progress bar, such as loading
 * or idle (not loading).
 */
sealed class ProgressBarState {

    /**
     * Represents the state when the progress bar is in the loading state.
     * This object is used to indicate that some operation is in progress, and the progress bar
     * should be shown to the user.
     */
    data object Loading : ProgressBarState()

    /**
     * Represents the state when the progress bar is in the idle state.
     * This object is used to indicate that there is no ongoing operation, and the progress bar
     * should be hidden or inactive.
     */
    data object Idle : ProgressBarState()
}
