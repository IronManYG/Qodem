package com.ironmanyg.profile_domain.user.identification

/**
 * Represents a user's identification details.
 *
 * @property idType The type of identification document the user possesses.
 * @property idNumber The identification number of the user's document.
 * @property communityId The ID representing the community the user belongs to. Can be null if not part of any community.
 */
data class Identification(
    val idType: IDType,
    val idNumber: String,
    val communityId: List<String>?
)