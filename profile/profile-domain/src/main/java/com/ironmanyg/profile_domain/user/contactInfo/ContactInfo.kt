package com.ironmanyg.profile_domain.user.contactInfo

/** Represents a user's contact information.
 *
 * @property address The detailed address of the user.
 * @property phoneNumber The phone number of the user.
 * @property email The email address of the user.
 * @property emergencyContact The emergency contact details for the user. Can be null if not provided.
 */
data class ContactInfo(
    val address: Address,
    val phoneNumber: String,
    val email: String,
    val emergencyContact: String?
)