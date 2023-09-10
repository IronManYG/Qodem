package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.contactInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.contactInfo.ContactInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the contact details of a donation center.
 *
 * This class provides multiple contact methods including phone, email, website, and social media,
 * making it easier for donors or other entities to get in touch with the center.
 *
 * @property phoneNumber Primary contact phone number of the donation center.
 * @property email Optional email address for communication; can be null if the center doesn't provide one.
 * @property website Official website URL of the donation center for more detailed information and resources.
 * @property socialMedia Contains various social media handles or links related to the donation center for outreach and updates.
 */
@Serializable
data class ContactInfoDto(
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("email")
    val email: String?,
    @SerialName("website")
    val website: String,
    @SerialName("social_media")
    val socialMedia: SocialMediaDto
)

/**
 * Converts a [ContactInfoDto] to a [ContactInfo].
 */
fun ContactInfoDto.toContactInfo() = ContactInfo(
    phoneNumber = phoneNumber,
    email = email,
    website = website,
    socialMedia = socialMedia.toSocialMedia()
)
