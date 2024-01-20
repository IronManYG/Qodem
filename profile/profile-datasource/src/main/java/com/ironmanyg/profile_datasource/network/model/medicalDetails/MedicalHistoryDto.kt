package com.ironmanyg.profile_datasource.network.model.medicalDetails

import com.ironmanyg.profile_domain.user.medicalDetails.MedicalHistory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) represents a user's medical history.
 * This class helps in transporting medical history data between network and app layers.
 *
 * @property pastIllnesses List of past illnesses the user had.
 * @property surgeries List of surgeries the user underwent.
 * @property allergies List of allergies the user has.
 * @property otherEvents Other relevant medical events or notes.
 */
@Serializable
data class MedicalHistoryDto(
    @SerialName("past_illnesses")
    val pastIllnesses: List<String>,
    @SerialName("surgeries")
    val surgeries: List<String>,
    @SerialName("allergies")
    val allergies: List<String>,
    @SerialName("other_events")
    val otherEvents: String?
) {
    /**
     * Converts MedicalHistoryDto object to MedicalHistory domain object.
     *
     * Direct mapping of all the fields from DTO to domain object is done.
     *
     * @return A MedicalHistory object with the data from this DTO.
     */
    fun toMedicalHistory() = MedicalHistory(
        pastIllnesses = pastIllnesses,
        surgeries = surgeries,
        allergies = allergies,
        otherEvents = otherEvents
    )
}


