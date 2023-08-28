package com.ironmanyg.profile_domain.user

/**
 * Represents a detailed address.
 *
 * @property postalCode The postal or ZIP code.Can be null if not provided.
 * @property street The street name or number.Can be null if not provided.
 * @property city The city where the user resides.
 * @property state The state or province.
 * @property country The country name.
 */
data class Address(
    val postalCode: String?,
    val street: String?,
    val city: String,
    val state: String,
    val country: String
)
