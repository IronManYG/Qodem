package com.ironmanyg.profile_domain.user

/**
 * Represents a user's medical history.
 *
 * @property pastIllnesses List of past illnesses the user had.
 * @property surgeries List of surgeries the user underwent.
 * @property allergies List of allergies the user has.
 * @property otherEvents Other relevant medical events or notes.
 */
data class MedicalHistory(
    val pastIllnesses: List<String>,
    val surgeries: List<String>,
    val allergies: List<String>,
    val otherEvents: String?
)