package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others

import com.ironmanyg.blood_donation_domain.donationCenter.others.CampaignDetails
import com.ironmanyg.blood_donation_domain.donationCenter.others.CampaignInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing campaign information in a format that is
 * serializable to facilitate data transfer over the network. This DTO maps directly to the
 * [CampaignInfo] domain object.
 *
 * @property campaignDetails Contains details about a specific campaign. It is nullable to handle potential null values from network responses gracefully.
 */
@Serializable
data class CampaignInfoDto(
    val campaignDetails: CampaignDetailsDto?,
)

/**
 * Data Transfer Object (DTO) representing detailed information about a campaign, which
 * includes the name, description, and start and end timestamps. This DTO maps directly
 * to the [CampaignDetails] domain object.
 *
 * @property name The name of the campaign.
 * @property description The description of the campaign.
 * @property startTimestamp The start timestamp of the campaign represented as a long.
 * @property endTimestamp The end timestamp of the campaign represented as a long.
 */
@Serializable
data class CampaignDetailsDto(
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("start_timestamp")
    val startTimestamp: Long,
    @SerialName("end_timestamp")
    val endTimestamp: Long,
)

/**
 * Extension function to convert a [CampaignInfoDto] instance to a [CampaignInfo] domain
 * object. This function facilitates the mapping from DTO to domain object, handling nullability gracefully.
 *
 * @return A [CampaignInfo] object with the corresponding data from the [CampaignInfoDto].
 */
fun CampaignInfoDto.toCampaignInfo() = CampaignInfo(
    campaignDetails = campaignDetails?.toCampaignDetails(),
)

/**
 * Extension function to convert a [CampaignDetailsDto] instance to a [CampaignDetails] domain
 * object. This function facilitates the mapping from DTO to domain object.
 *
 * @return A [CampaignDetails] object with the corresponding data from the [CampaignDetailsDto].
 */
fun CampaignDetailsDto.toCampaignDetails() = CampaignDetails(
    name = name,
    description = description,
    startTimestamp = startTimestamp,
    endTimestamp = endTimestamp,
)
