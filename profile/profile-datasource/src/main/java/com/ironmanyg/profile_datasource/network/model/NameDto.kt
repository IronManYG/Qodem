package com.ironmanyg.profile_datasource.network.model

import com.ironmanyg.profile_domain.user.Name
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing the name of a user in the blood donation system. This class helps in transporting user name data between network and app layers.
 *
 * @property firstName The first name of the user.
 * @property middleName The middle name of the user. Can be null if not provided.
 * @property lastName The last name of the user.
 */
@Serializable
data class NameDto(
    @SerialName("first_name")
    val firstName: String,
    @SerialName("middle_name")
    val middleName: String?,
    @SerialName("last_name")
    val lastName: String
)

/**
 * Extension function to convert NameDto object to Name domain model object. This aids in mapping the network response object to the domain object, facilitating cleaner and maintainable code by separating concerns.
 *
 * @return A Name domain model object with properties mapped from the NameDto object.
 */
fun NameDto.toName() = Name(
    firstName = firstName,
    middleName = middleName,
    lastName = lastName
)
