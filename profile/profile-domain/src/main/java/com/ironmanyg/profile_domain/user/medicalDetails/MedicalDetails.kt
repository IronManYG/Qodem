package com.ironmanyg.profile_domain.user.medicalDetails

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType

/**
 * Represents a user's medical details.
 *
 * @property bloodType The blood type of the user.
 * @property weight The weight of the user in kilograms.
 * @property height The height of the user in centimeters.
 * @property medicalHistory The medical history of the user. Can be null if not provided.
 * @property medicalCondition The ongoing or chronic medical conditions of the user. Can be null if not provided.
 * @property eligibilityStatus Indicates if the user is currently eligible to donate.
 */
data class MedicalDetails(
    val bloodType: BloodType,
    val weight: Int,
    val height: Int,
    val medicalHistory: MedicalHistory?,
    val medicalCondition: MedicalCondition?,
    val eligibilityStatus: Boolean
)
