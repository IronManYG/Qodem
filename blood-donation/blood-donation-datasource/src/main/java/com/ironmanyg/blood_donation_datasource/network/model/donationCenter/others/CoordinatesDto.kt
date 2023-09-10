package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others

import com.ironmanyg.blood_donation_domain.donationCenter.others.Coordinates
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing the geographical coordinates with attributes for both latitude and longitude. This class facilitates the mapping from JSON payload attributes to Kotlin properties when fetching data from network services.
 *
 * @property latitude The north-south position of a point on the Earth's surface. Mapped from "latitude" in the JSON payload.
 * @property longitude The east-west position of a point on the Earth's surface. Mapped from "longitude" in the JSON payload.
 */
@Serializable
data class CoordinatesDto(
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double
)

/**
 * Extension function to convert a [CoordinatesDto] instance to a [Coordinates] domain model. This separation facilitates the maintenance of a clean architecture by keeping network-related logics within the DTO, while providing a straightforward conversion to a domain model for use in the rest of the application.
 *
 * @receiver The [CoordinatesDto] instance to be converted.
 * @return A [Coordinates] domain model with the values copied from the [CoordinatesDto] instance.
 */
fun CoordinatesDto.toCoordinates() = Coordinates(
    latitude = latitude,
    longitude = longitude
)
