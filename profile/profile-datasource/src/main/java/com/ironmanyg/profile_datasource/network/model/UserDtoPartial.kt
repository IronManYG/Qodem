package com.ironmanyg.profile_datasource.network.model

import com.ironmanyg.profile_datasource.network.model.contactInfo.ContactInfoDto
import com.ironmanyg.profile_datasource.network.model.donationDetails.DonationDetailsDto
import com.ironmanyg.profile_datasource.network.model.identification.IdentificationDto
import com.ironmanyg.profile_datasource.network.model.medicalDetails.MedicalDetailsDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a partial data transfer object for a user profile.
 * This class is particularly useful when only a subset of a user's attributes need to be sent or received.
 *
 * All attributes are nullable, meaning any combination of them can be present.
 *
 * @property id The unique identifier for the user.
 * @property name The DTO object representing the full name of the user.
 * @property imageName The URL or name of the user's profile image. Can be null if not provided.
 * @property birthDate The user's birth date represented in milliseconds since the Unix epoch.
 * @property gender The gender of the user represented as a string.
 * @property contactInfo DTO object containing the contact information of the user.
 * @property identification DTO object containing the identification details of the user.
 * @property medicalDetails DTO object containing the medical details of the user.
 * @property donationDetails DTO object containing the donation history and details of the user.
 * @property preferredDonationCenterId The ID of the user's preferred donation center. Can be null if not set.
 */
@Serializable
data class UserDtoPartial(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: NameDto?,
    @SerialName("image_name")
    val imageName: String?,
    @SerialName("birth_date")
    val birthDate: Long?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("contact_info")
    val contactInfo: ContactInfoDto?,
    @SerialName("identification")
    val identification: IdentificationDto?,
    @SerialName("medical_details")
    val medicalDetails: MedicalDetailsDto?,
    @SerialName("donation_details")
    val donationDetails: DonationDetailsDto?,
    @SerialName("preferred_donation_center_id")
    val preferredDonationCenterId: String?
)