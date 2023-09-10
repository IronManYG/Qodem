package com.ironmanyg.blood_donation_domain.donationCenter.operationInfo

/**
 * Represents an individual slot within a time slot.
 *
 * @property id Unique identifier for the slot.
 * @property parentId ID of the parent time slot.
 * @property isAvailable Indicates if the slot is available for booking.
 * @property donorLimit Maximum number of donors that can be accommodated in this slot.
 */
data class Slot(
    val id: Int,
    val parentId: Int,
    val isAvailable: Boolean,
    val donorLimit: Int,
)