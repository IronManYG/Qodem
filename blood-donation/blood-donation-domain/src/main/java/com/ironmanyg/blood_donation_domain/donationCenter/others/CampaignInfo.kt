package com.ironmanyg.blood_donation_domain.donationCenter.others

/**
 * Represents the status and details of any ongoing blood donation campaigns.
 */
data class CampaignInfo(
    val campaign: CampaignDetails?  // Contains campaign details if there's an active campaign, null otherwise.
)

/**
 * Represents the details of an ongoing blood donation campaign.
 *
 * @property name The name or title of the campaign.
 * @property description A brief description or objective of the campaign.
 * @property startTimestamp The UNIX timestamp representing the starting date-time of the campaign.
 * @property endTimestamp The UNIX timestamp representing the ending date-time of the campaign.
 * @property duration The duration of the campaign, calculated from the difference between the end and start timestamps.
 */
data class CampaignDetails(
    val name: String,
    val description: String,
    val startTimestamp: Long,
    val endTimestamp: Long,
) {
    val duration: Long get() = endTimestamp - startTimestamp
}
