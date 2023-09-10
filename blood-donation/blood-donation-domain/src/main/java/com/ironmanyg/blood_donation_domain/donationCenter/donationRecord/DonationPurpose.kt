package com.ironmanyg.blood_donation_domain.donationCenter.donationRecord

/**
 * Represents the different purposes or reasons for blood donations.
 *
 * Each type within this sealed class elucidates the underlying reason or intent behind a blood donation.
 *
 * @property description A brief descriptor of the donation purpose.
 */
sealed class DonationPurpose(val description: String) {

    /**
     * Directed donation refers to a scenario where a donor specifically designates their blood
     * for a particular recipient.
     */
    data object DirectedDonation : DonationPurpose("Directed donation")

    /**
     * Voluntary donation embodies the altruistic act of donating blood without designating
     * it for any particular individual.
     */
    data object VoluntaryDonation : DonationPurpose("Voluntary donation")

    /**
     * Replacement donation is when friends or family donate blood to "replace" the blood
     * used by a specific patient, essentially replenishing the blood bank's supply.
     */
    data object ReplacementDonation : DonationPurpose("Replacement donation")

    /**
     * Autologous donation refers to the process where individuals donate blood primarily
     * for their own future use, often in anticipation of a planned surgery or medical procedure.
     */
    data object AutologousDonation : DonationPurpose("Autologous donation")

    companion object {
        /**
         * Provides a consolidated list of all available blood donation purposes.
         *
         * @return A list of [DonationPurpose] instances.
         */
        fun getAll(): List<DonationPurpose> = listOf(
            DirectedDonation, VoluntaryDonation, ReplacementDonation,
            AutologousDonation,
        )
    }
}
