package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.WorkingHours
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * DTO representing the working hours details fetched from a network source.
 *
 * This DTO encapsulates the start and end time of the operation hours and
 * can be converted to a domain model using the [toWorkingHours] extension function.
 *
 * @see WorkingHours
 */
@Serializable
data class WorkingHoursDto(
    @SerialName("start_time")
    val startTime: SimpleTimeDto,
    @SerialName("end_time")
    val endTime: SimpleTimeDto
)

/**
 * Extension function to map a [WorkingHoursDto] instance to a [WorkingHours] domain model.
 *
 * This function leverages the [SimpleTimeDto.toSimpleTime] function to convert start and end time
 * from DTO representations to domain model representations.
 *
 * @return A [WorkingHours] instance with values mapped from the [WorkingHoursDto].
 */
fun WorkingHoursDto.toWorkingHours() = WorkingHours(
    startTime = startTime.toSimpleTime(),
    endTime = endTime.toSimpleTime()
)
