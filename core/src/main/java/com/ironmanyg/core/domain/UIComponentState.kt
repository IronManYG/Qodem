package com.ironmanyg.core.domain

/**
 * A sealed class that represents the states for showing or hiding a UI component in an application.
 * UIComponentState is a generic class used to control the visibility of UI components by switching
 * between the "Show" and "Hide" states.
 */
sealed class UIComponentState {

    /**
     * Represents the state when the UI component should be shown.
     * This object is used to indicate that a particular UI component, such as a dialog, notification,
     * or SnackBar, should be made visible to the user.
     */
    data object Show : UIComponentState()

    /**
     * Represents the state when the UI component should be hidden.
     * This object is used to indicate that a previously visible UI component should be hidden or
     * removed from the screen.
     */
    data object Hide : UIComponentState()
}
