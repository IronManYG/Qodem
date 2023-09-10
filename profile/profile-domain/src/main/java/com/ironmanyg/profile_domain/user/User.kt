package com.ironmanyg.profile_domain.user

import com.ironmanyg.profile_domain.user.contactInfo.ContactInfo
import com.ironmanyg.profile_domain.user.donationDetails.DonationDetails
import com.ironmanyg.profile_domain.user.identification.Identification
import com.ironmanyg.profile_domain.user.medicalDetails.MedicalDetails

/**
 * Represents a user in the blood donation system.
 *
 * @property id The unique identifier for the user.
 * @property name The full name of the user.
 * @property imageName The URL or name of the user's profile image. Can be null if not provided.
 * @property birthDate The user's birth date represented in milliseconds since the Unix epoch.
 * @property gender The gender of the user.
 * @property contactInfo The contact information of the user.
 * @property identification The identification details of the user.
 * @property medicalDetails The medical details of the user.
 * @property donationDetails The donation history and details of the user.
 * @property preferredDonationCenterId The ID of the user's preferred donation center. Can be null if not set.
 */
data class User(
    val id: String,
    val name: Name,
    val imageName: String?,
    val birthDate: Long,
    val gender: Gender,
    val contactInfo: ContactInfo,
    val identification: Identification,
    val medicalDetails: MedicalDetails,
    val donationDetails: DonationDetails,
    val preferredDonationCenterId: String?
)
