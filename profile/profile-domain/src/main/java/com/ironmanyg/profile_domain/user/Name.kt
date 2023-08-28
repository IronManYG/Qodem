package com.ironmanyg.profile_domain.user

/**
 * Represents a user's full name.
 *
 * @property firstName The first name of the user.
 * @property middleName The middle name of the user. Can be null if not provided.
 * @property lastName The last name of the user.
 */
data class Name(
    val firstName: String,
    val middleName: String?,
    val lastName: String
){
    override fun toString(): String {
        return "$firstName ${middleName ?: ""} $lastName"
    }
}