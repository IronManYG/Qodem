package com.ironmanyg.blood_donation_domain.donationCenter.others

/**
 * Represents detailed address information of a donation center.
 *
 * @property city City where the donation center is located.
 * @property state State where the donation center is located.
 * @property country Country where the donation center is located.
 * @property coordinates Geographical coordinates of the donation center.
 * @property locationDescription General location description of the donation center. .Can be null if not provided.
 */
data class AddressInfo(
    val city: String,
    val state: String,
    val country: String,
    val coordinates: Coordinates,
    val locationDescription: String?
)