package com.ironmanyg.profile_datasource.network.model.contactInfo

import com.ironmanyg.profile_domain.user.contactInfo.Address
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing the address details of a user in the blood donation system. This class facilitates the transfer of user address data between the network and app layers.
 *
 * @property postalCode The postal code of the user's address. It can be null if not provided.
 * @property street The street name of the user's address. It can be null if not provided.
 * @property city The city of the user's residence.
 * @property state The state of the user's residence.
 * @property country The country of the user's residence.
 */
@Serializable
data class AddressDto(
    @SerialName("postal_code")
    val postalCode: String?,
    @SerialName("street")
    val street: String?,
    @SerialName("city")
    val city: String,
    @SerialName("state")
    val state: String,
    @SerialName("country")
    val country: String
)

/**
 * Extension function to convert AddressDto object to Address domain model object. This function helps in keeping the network layer separated from the domain layer, aiding in the maintenance of a clean and scalable codebase.
 *
 * @return An Address domain model object with properties mapped from the AddressDto object.
 */
fun AddressDto.toAddress() = Address(
    postalCode = postalCode,
    street = street,
    city = city,
    state = state,
    country = country
)
