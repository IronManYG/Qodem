package com.ironmanyg.core.domain

sealed class UIComponent {

    /**
     * Represents a Dialog UI component, typically used to display important information or
     * receive user input. It contains a title and description for the dialog.
     *
     * @param title The title of the dialog.
     * @param description The description or message shown in the dialog.
     * @param buttons A list of buttons (Button) that the Dialog may include for handling
     * user actions. If no buttons are needed, this list can be empty or null.
     */
    data class Dialog(
        val title: String,
        val description: String,
        val buttons: List<GeneralButton<*>>? = null
    ) : UIComponent()

    /**
     * Represents a Notification UI component, typically used to inform users about important
     * events or updates. It may contain a title and description.
     *
     * @param title The title of the notification.
     * @param description The description or message shown in the notification.
     * @param buttons A list of buttons (Button) that the Notification may include for handling
     * user actions. If no buttons are needed, this list can be empty or null.
     */
    data class Notification(
        val title: String? = null,
        val description: String,
        val buttons: List<GeneralButton<*>>? = null
    ) : UIComponent()

    /**
     * Represents a SnackBar UI component, typically used to display brief messages or alerts
     * at the bottom of the screen. It contains the message to be shown in the SnackBar and
     * can include buttons to handle user actions.
     *
     * @param message The message to be shown in the SnackBar.
     * @param buttons A list of buttons (Button) that the SnackBar may include for handling
     * user actions. If no buttons are needed, this list can be empty or null.
     */
    data class SnackBar(
        val message: String,
        val buttons: List<GeneralButton<*>>? = null
    ) : UIComponent()

    /**
     * Represents a Toast UI component, typically used to display short messages or notifications
     * on the screen. Toasts are non-intrusive and automatically disappear after a short duration.
     *
     * @param message The message to be displayed in the Toast.
     */
    data class Toast(
        val message: String
    ) : UIComponent()

    /**
     * Represents a None UI component, used to indicate that there is no specific UI component required
     * for the current scenario. It serves as a placeholder or an empty UI component that can be utilized
     * in certain situations.
     *
     * This component can be employed for various purposes, such as logging messages, tracking events,
     * or sending crash reports to Crashlytics. When used as a logging component, it may contain a
     * descriptive message providing additional context or information related to the log entry.
     *
     * @param message An optional message associated with the None component, used for additional context
     * or providing relevant information when utilized as a log entry.
     */
    data class None(
        val message: String? = null,
    ) : UIComponent()

    /**
     * Represents a general button that can be used in various UI components.
     *
     * @param label The label or text shown on the button.
     * @param onClickAction An optional lambda function representing the action to be performed
     * when the button is clicked. If no action is needed, this can be set to null.
     */
    data class GeneralButton<T>(
        val label: String,
        val onClickAction: ((T) -> Unit)? = null
    )
}


