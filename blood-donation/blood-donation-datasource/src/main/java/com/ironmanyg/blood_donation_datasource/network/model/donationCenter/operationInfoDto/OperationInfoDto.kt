package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.OperationInfo
import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.stringDaysToListOfDays
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DTO representing the operational details of a blood donation center fetched from a network source.
 *
 * This DTO encapsulates various operational details including working hours, operational days,
 * time slots, etc., which can be converted to a domain model using the [toOperationInfo] extension function.
 *
 * @see OperationInfo
 */
@Serializable
data class OperationInfoDto(
    @SerialName("working_hours")
    val workingHours: WorkingHoursDto,
    @SerialName("working_days")
    val workingDays: List<String>,
    @SerialName("gap_between_appointment")
    val gapBetweenAppointment: Int,
    @SerialName("donor_limit")
    val donorLimit: Int,
    @SerialName("time_slots")
    val timeSlots: List<TimeSlotDto>
)

/**
 * Extension function to map an [OperationInfoDto] instance to an [OperationInfo] domain model.
 *
 * This function leverages other mapping functions such as [WorkingHoursDto.toWorkingHours]
 * and [stringDaysToListOfDays] to facilitate the conversion from DTO to domain model.
 *
 * @return An [OperationInfo] instance with values mapped from the [OperationInfoDto].
 */
fun OperationInfoDto.toOperationInfo() = OperationInfo(
    workingHours = workingHours.toWorkingHours(),
    workingDays = stringDaysToListOfDays(workingDays),
    gapBetweenAppointment = gapBetweenAppointment,
    donorLimit = donorLimit,
    timeSlots = timeSlots.map { it.toTimeSlot() }
)
