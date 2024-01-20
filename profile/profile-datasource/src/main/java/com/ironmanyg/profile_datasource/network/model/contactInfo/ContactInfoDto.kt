package com.ironmanyg.profile_datasource.network.model.contactInfo

import com.ironmanyg.profile_domain.user.contactInfo.ContactInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing the contact information of a user in the blood donation system. This class facilitates the transportation of user contact data between the network and app layers.
 *
 * @property address The DTO object holding the address details of the user.
 * @property phoneNumber The phone number of the user.
 * @property email The email address of the user.
 * @property emergencyContact The emergency contact number of the user. It can be null if not provided.
 */
@Serializable
data class ContactInfoDto(
    @SerialName("address")
    val address: AddressDto,
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("email")
    val email: String,
    @SerialName("emergency_contact")
    val emergencyContact: String?
)

/**
 * Extension function to convert ContactInfoDto object to ContactInfo domain model object. This function aids in separating concerns by mapping the network response objects to domain objects, thus promoting cleaner and more maintainable code.
 *
 * @return A ContactInfo domain model object with properties mapped from the ContactInfoDto object.
 */
fun ContactInfoDto.toContactInfo() = ContactInfo(
    address = address.toAddress(),
    phoneNumber = phoneNumber,
    email = email,
    emergencyContact = emergencyContact
)
