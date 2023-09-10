package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.SimpleTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a specific time during the day, mainly used for defining operation hours.
 *
 * This structure can be utilized to depict exact hours and minutes, ensuring consistency
 * and accuracy while detailing operational details of entities such as donation centers.
 *
 * @property hour The hour of the day, ranging from 0 (midnight) to 23 (11 PM).
 * @property minute The minute within the hour, ranging from 0 to 59.
 */
@Serializable
data class SimpleTimeDto(
    @SerialName("hour")
    val hour: Int,
    @SerialName("minute")
    val minute: Int
)

/**
 * Converts a [SimpleTimeDto] to a [SimpleTime].
 */
fun SimpleTimeDto.toSimpleTime() = SimpleTime(
    hour = hour,
    minute = minute
)
