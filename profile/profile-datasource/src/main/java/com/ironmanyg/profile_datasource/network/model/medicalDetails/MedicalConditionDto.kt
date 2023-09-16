package com.ironmanyg.profile_datasource.network.model.medicalDetails

import com.ironmanyg.profile_domain.user.medicalDetails.MedicalCondition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) Represents a user's ongoing or chronic medical conditions.
 * This class helps in transporting medical condition data between network and app layers.
 *
 * @property conditions List of ongoing or chronic conditions.
 * @property medications List of medications the user is currently taking.
 * @property specialCare Any special care or attention needed for the user.
 */
@Serializable
data class MedicalConditionDto(
    @SerialName("conditions")
    val conditions: List<String>,
    @SerialName("medications")
    val medications: List<String>,
    @SerialName("special_care")
    val specialCare: String?
) {
    /**
     * Converts MedicalDetailsDto object to MedicalDetails domain object.
     *
     * The blood type is split into two components: blood group and Rh factor
     * which are determined by the first and last characters of the bloodType string respectively.
     *
     * @return A MedicalDetails object with the data from this DTO.
     */
    fun toMedicalCondition() = MedicalCondition(
        conditions = conditions,
        medications = medications,
        specialCare = specialCare
    )
}


