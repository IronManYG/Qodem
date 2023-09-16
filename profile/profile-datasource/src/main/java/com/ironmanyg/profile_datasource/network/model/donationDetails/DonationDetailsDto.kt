package com.ironmanyg.profile_datasource.network.model.donationDetails

import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.donationRecord.DonationRecordDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.donationRecord.toDonationRecord
import com.ironmanyg.profile_domain.user.donationDetails.Badge
import com.ironmanyg.profile_domain.user.donationDetails.DonationDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing the detailed information regarding a user's donations.
 * This DTO is annotated with [Serializable] to work with Kotlin serialization for parsing JSON responses.
 *
 * @property numberOfDonations The total number of times the user has donated.
 * @property badges A list of badges the user has earned.
 * @property donationPoints Points earned by the user for donations.
 * @property donations A list of donation records associated with the user.
 * @property lastDonationDate The date of the user's last donation, represented in milliseconds since the Unix epoch. Can be null if the user hasn't donated yet.
 */
@Serializable
data class DonationDetailsDto(
    @SerialName("number_of_donations")
    val numberOfDonations: Int,

    @SerialName("badges")
    val badges: List<String>,

    @SerialName("donation_points")
    val donationPoints: Int,

    @SerialName("donations")
    val donations: List<DonationRecordDto>,

    @SerialName("last_donation_date")
    val lastDonationDate: Long?
)

/**
 * Extension function to convert [DonationDetailsDto] to a [DonationDetails] domain model.
 *
 * @return A [DonationDetails] object that represents the donation details in the domain layer.
 */
fun DonationDetailsDto.toDonationDetails() = DonationDetails(
    numberOfDonations = numberOfDonations,
    badges = badges.map { Badge.fromName(it) },
    donationPoints = donationPoints,
    donations = donations.map { it.toDonationRecord() },
    lastDonationDate = lastDonationDate
)
