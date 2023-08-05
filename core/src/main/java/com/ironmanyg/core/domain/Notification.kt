package com.ironmanyg.core.domain

/**
 * Represents a notification in the application.
 *
 * Notifications are used to deliver important information or updates to the user. Each notification
 * has an identifier (id), a title, and a message (msg).
 *
 * @param id The unique identifier of the notification.
 * @param title The title of the notification, providing a brief summary or heading for the content.
 * @param msg The main message content of the notification, conveying the important information to the user.
 */
data class Notification(
    val id: Int,
    val title: String,
    val msg: String,
)
