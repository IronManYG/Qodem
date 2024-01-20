package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others

import com.ironmanyg.blood_donation_domain.donationCenter.others.AddressInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) that facilitates the transfer of address information of a donation center between the network and the app. The information consists of various properties detailing the address in different capacities.
 *
 * @property city The city where the donation center is located, mapped from "city" in the JSON payload.
 * @property state The state where the donation center is located, mapped from "state" in the JSON payload.
 * @property country The country where the donation center is located, mapped from "country" in the JSON payload.
 * @property coordinates The geographical coordinates of the donation center, holding a [CoordinatesDto] object mapped from "coordinates" in the JSON payload.
 * @property locationDescription An optional property providing a general description of the donation center's location. It can be null if not provided, mapped from "location_description" in the JSON payload.
 */
@Serializable
data class AddressInfoDto(
    @SerialName("city")
    val city: String,
    @SerialName("state")
    val state: String,
    @SerialName("country")
    val country: String,
    @SerialName("coordinates")
    val coordinates: CoordinatesDto,
    @SerialName("location_description")
    val locationDescription: String?
)

/**
 * Extension function to facilitate the conversion of an [AddressInfoDto] instance to a domain model [AddressInfo]. The method ensures separation of concerns between the network-related logic and the rest of the application, promoting a cleaner architecture.
 *
 * @receiver The [AddressInfoDto] instance to convert.
 * @return An [AddressInfo] instance with values mirrored from the [AddressInfoDto].
 */
fun AddressInfoDto.toAddressInfo() = AddressInfo(
    city = city,
    state = state,
    country = country,
    coordinates = coordinates.toCoordinates(),
    locationDescription = locationDescription
)
