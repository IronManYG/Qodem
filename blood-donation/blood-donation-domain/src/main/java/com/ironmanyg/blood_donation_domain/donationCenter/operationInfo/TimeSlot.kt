package com.ironmanyg.blood_donation_domain.donationCenter.operationInfo

/**
 * Represents a specific time slot for blood donation at a center.
 *
 * @property id Unique identifier for the time slot.
 * @property startTime Start time of the slot (in milliseconds since epoch).
 * @property endTime End time of the slot (in milliseconds since epoch).
 * @property date Date of the slot (in milliseconds since epoch).
 * @property donationCenterId ID of the associated donation center.
 * @property timeBetweenAppointments Time gap (in minutes) between each appointment in this slot.
 * @property remainingDonationAppointments Number of remaining appointments in this slot.
 * @property isFullyBooked Indicates if the time slot is fully booked.
 * @property slots List of individual slots within this time slot.
 */
data class TimeSlot(
    val id: Int,
    val startTime: Long,
    val endTime: Long,
    val date: Long,
    val donationCenterId: Int,
    val timeBetweenAppointments: Int,
    val remainingDonationAppointments: Int,
    val isFullyBooked: Boolean,
    val slots: List<Slot>,
)