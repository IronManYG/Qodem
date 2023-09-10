package com.ironmanyg.blood_donation_domain.donationCenter.contactInfo

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
data class ContactInfo(
    val phoneNumber: String,
    val email: String?,
    val website: String,
    val socialMedia: SocialMedia
)
