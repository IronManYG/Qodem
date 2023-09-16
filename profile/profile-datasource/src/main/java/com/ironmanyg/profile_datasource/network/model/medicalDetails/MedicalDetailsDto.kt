package com.ironmanyg.profile_datasource.network.model.medicalDetails

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodGroup
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.RhFactor
import com.ironmanyg.profile_domain.user.medicalDetails.MedicalDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing a user's medical details.
 * This class helps in transporting medical details data between network and app layers.
 *
 * @property bloodType The blood type of the user.
 * @property weight The weight of the user in kilograms.
 * @property height The height of the user in centimeters.
 * @property medicalHistory The medical history of the user. Can be null if not provided.
 * @property medicalCondition The ongoing or chronic medical conditions of the user. Can be null if not provided.
 * @property eligibilityStatus Indicates if the user is currently eligible to donate.
 */
@Serializable
data class MedicalDetailsDto(
    @SerialName("blood_type")
    val bloodType: String,
    @SerialName("weight")
    val weight: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("medical_history")
    val medicalHistory: MedicalHistoryDto?,
    @SerialName("medical_condition")
    val medicalCondition: MedicalConditionDto?,
    @SerialName("eligibility_status")
    val eligibilityStatus: Boolean
) {
    /**
     * Converts MedicalConditionDto object to MedicalCondition domain object.
     *
     * Direct mapping of all the fields from DTO to domain object is done.
     *
     * @return A MedicalCondition object with the data from this DTO.
     */
    fun toMedicalDetails() = MedicalDetails(
        bloodType = BloodType.fromComponents(
            BloodGroup.valueOf(bloodType.first().toString()),
            RhFactor.fromSymbol(bloodType.last().toString()),
        ),
        weight = weight,
        height = height,
        medicalHistory = medicalHistory?.toMedicalHistory(),
        medicalCondition = medicalCondition?.toMedicalCondition(),
        eligibilityStatus = eligibilityStatus
    )
}

