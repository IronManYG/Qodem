package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others

import com.ironmanyg.blood_donation_domain.donationCenter.others.NameInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) class which represents the name information of a donation center in various languages. It is annotated with [Serializable] to allow serializing and deserializing from JSON when communicating with a network service.
 *
 * @property english The name of the donation center in English. It maps to "english_name" in the JSON payload.
 * @property arabic The name of the donation center in Arabic. It maps to "arabic_name" in the JSON payload.
 */
@Serializable
data class NameInfoDto(
    @SerialName("english_name")
    val english: String,
    @SerialName("arabic_name")
    val arabic: String
)

/**
 * Extension function to convert a [NameInfoDto] instance to a [NameInfo] domain object. This function facilitates the separation of concerns by keeping network-specific logic in the DTO, while allowing easy conversion to a domain object for use in the rest of the application.
 *
 * @receiver The [NameInfoDto] instance to convert.
 * @return A [NameInfo] instance with values copied from the [NameInfoDto] instance.
 */
fun NameInfoDto.toNameInfo() = NameInfo(
    english = english,
    arabic = arabic
)
