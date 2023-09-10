package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.OperationInfo
import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.stringDaysToListOfDays
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class encapsulating the operational details of a blood donation center.
 *
 * It embodies the working hours using a structured time format, a list of operational days,
 * the interlude between appointments, the maximum donor capacity, and a list of available time slots.
 *
 * @property workingHours A pair of SimpleTime instances representing the start
 *                        and end of the working hours. For instance, if the working hours
 *                        are from 9 AM to 5 PM, the pair would be (SimpleTime(9, 0), SimpleTime(17, 0)).
 * @property workingDays A list detailing the specific days of the week when the
 *                       donation center is operational.
 * @property gapBetweenAppointment An integer indicating the time interval (in minutes)
 *                                 between consecutive donor appointments, ensuring efficient
 *                                 donor management.
 * @property donorLimit An integer representing the utmost number of donors the
 *                      center can handle simultaneously or within a day.
 * @property timeSlots A list detailing the explicit time slots during which donors
 *                     can book appointments, aiding in efficient scheduling.
 */
@Serializable
data class OperationInfoDto(
    @SerialName("working_hours")
    val workingHours: Pair<SimpleTimeDto, SimpleTimeDto>,
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
 * Converts an [OperationInfoDto] to an [OperationInfo].
 */
fun OperationInfoDto.toOperationInfo() = OperationInfo(
    workingHours = Pair(workingHours.first.toSimpleTime(), workingHours.second.toSimpleTime()),
    workingDays = stringDaysToListOfDays(workingDays),
    gapBetweenAppointment = gapBetweenAppointment,
    donorLimit = donorLimit,
    timeSlots = timeSlots.map { it.toTimeSlot() }
)
