package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.contactInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.contactInfo.SocialMedia
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
@Serializable
data class SocialMediaDto(
    @SerialName("facebook")
    val facebook: String?,
    @SerialName("twitter")
    val twitter: String?,
    @SerialName("instagram")
    val instagram: String?,
    @SerialName("linkedIn")
    val linkedIn: String?
)

/**
 * Converts a [SocialMediaDto] to a [SocialMedia].
 */
fun SocialMediaDto.toSocialMedia() = SocialMedia(
    facebook = facebook,
    twitter = twitter,
    instagram = instagram,
    linkedIn = linkedIn
)
