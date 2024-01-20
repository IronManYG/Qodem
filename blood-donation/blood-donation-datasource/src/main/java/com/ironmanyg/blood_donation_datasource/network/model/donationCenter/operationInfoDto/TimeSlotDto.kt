package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.TimeSlot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
@Serializable
data class TimeSlotDto(
    @SerialName("id")
    val id: Int,
    @SerialName("start_time")
    val startTime: Long,
    @SerialName("end_time")
    val endTime: Long,
    @SerialName("date")
    val date: Long,
    @SerialName("donation_center_id")
    val donationCenterId: Int,
    @SerialName("time_between_appointments")
    val timeBetweenAppointments: Int,
    @SerialName("remaining_donation_appointments")
    val remainingDonationAppointments: Int,
    @SerialName("is_fully_booked")
    val isFullyBooked: Boolean,
    @SerialName("slots")
    val slots: List<SlotDto>,
)

/**
 * Converts a [TimeSlotDto] to a [TimeSlot].
 */
fun TimeSlotDto.toTimeSlot() = TimeSlot(
    id = id,
    startTime = startTime,
    endTime = endTime,
    date = date,
    donationCenterId = donationCenterId,
    timeBetweenAppointments = timeBetweenAppointments,
    remainingDonationAppointments = remainingDonationAppointments,
    isFullyBooked = isFullyBooked,
    slots = slots.map { it.toSlot() }
)
