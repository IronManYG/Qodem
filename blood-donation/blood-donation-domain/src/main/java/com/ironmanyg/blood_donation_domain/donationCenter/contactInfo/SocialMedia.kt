package com.ironmanyg.blood_donation_domain.donationCenter.contactInfo

/**
 * Represents the social media presence of a donation center.
 *
 * This class encapsulates the different social media handles or links associated with a donation center.
 * Each property represents a particular social media platform and can be null if the center is not present on that platform.
 *
 * @property facebook The Facebook page/handle link of the donation center, or null if not available.
 * @property twitter The Twitter handle/link of the donation center, or null if not available.
 * @property instagram The Instagram handle/link of the donation center, or null if not available.
 * @property linkedIn The LinkedIn page/link of the donation center, or null if not available.
 */
data class SocialMedia(
    val facebook: String?,
    val twitter: String?,
    val instagram: String?,
    val linkedIn: String?
)
