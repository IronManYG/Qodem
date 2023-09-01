package com.ironmanyg.blood_donation_domain.donationCenter.donationEvent

/**
 * Represents the organizer of the donation event, which can be an individual, organization, or community.
 *
 * @property id The unique identifier of the organizer.
 * @property type The type of the organizer, denoting if it's an individual, organization, or community.
 */
data class Organizer(
    val id: Int,
    val type: OrganizerType
)