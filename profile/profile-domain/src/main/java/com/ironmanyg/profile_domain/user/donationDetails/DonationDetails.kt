package com.ironmanyg.profile_domain.user.donationDetails

import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.DonationRecord

/**
 * Represents a user's donation details.
 *
 * @property numberOfDonations The total number of times the user has donated.
 * @property badges A list of badges the user has earned.
 * @property donationPoints Points earned by the user for donations.
 * @property donations A list of donation records associated with the user.
 * @property lastDonationDate The date of the user's last donation, represented in milliseconds since the Unix epoch. Can be null if the user hasn't donated yet.
 */
data class DonationDetails(
    val numberOfDonations: Int,
    val badges: List<Badge>,
    val donationPoints: Int,
    val donations: List<DonationRecord>,
    val lastDonationDate: Long?
)