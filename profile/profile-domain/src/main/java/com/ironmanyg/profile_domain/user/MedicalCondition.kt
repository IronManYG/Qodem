package com.ironmanyg.profile_domain.user

/**
 * Represents a user's ongoing or chronic medical conditions.
 *
 * @property conditions List of ongoing or chronic conditions.
 * @property medications List of medications the user is currently taking.
 * @property specialCare Any special care or attention needed for the user.
 */
data class MedicalCondition(
    val conditions: List<String>,
    val medications: List<String>,
    val specialCare: String?
)