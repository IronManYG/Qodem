package com.ironmanyg.blood_donation_domain.donationCenter.donationEvent

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType
import com.ironmanyg.blood_donation_domain.donationCenter.others.AddressInfo

/**
 * A data representation of a specific blood donation event. The event could be associated with a specific
 * donation center or could be taking place at an independent venue. Each event has properties that detail
 * its timeframe, the blood types it aims to collect, and the attendees.
 *
 * @property id A unique identifier for the donation event.
 * @property name A descriptive name for the donation event.
 * @property description A short summary describing the event.
 * @property startDate A timestamp indicating when the event begins.
 * @property endDate A timestamp indicating when the event concludes.
 * @property donationCenterId (Optional) The identifier of the associated donation center if the event is tied to one.
 * @property venue (Optional) If the event isn't at a predefined donation center, this provides the venue details.
 * @property targetUnits Represents the collection goal. It maps each blood type to the number of units intended to be collected.
 * @property attendees A list of user IDs that have shown interest or registered to participate in the event.
 * @property organizer Details about the entity organizing the event; could be an individual, community group, or organization.
 * @property isEmergency A flag to signify if the event is emergent, indicating a dire need for donations.
 * @property isEventEnded A flag to check if the event has been manually ended by an organizer or donation center before the actual end time.
 */
data class DonationEvent(
    val id: Int,
    val name: String,
    val description: String,
    val startDate: Long,
    val endDate: Long,
    val donationCenterId: Int?,
    val venue: AddressInfo?,
    val targetUnits: Map<BloodType, Int>?,
    val attendees: List<Int>,
    val organizer: Organizer,
    val isEmergency: Boolean = false,
    val isEventEnded: Boolean = false
) {
    /**
     * Ensures that a donation event is either tied to an established donation center or a standalone venue,
     * but not both simultaneously. If neither or both values are provided, it throws an exception detailing the issue.
     *
     * @throws IllegalArgumentException If both 'donationCenterId' and 'venue' are provided or if neither are provided.
     */
    init {
        when {
            donationCenterId != null && venue != null ->
                throw IllegalArgumentException("Both donationCenterId and venue are provided. Please provide only one.")
            donationCenterId == null && venue == null ->
                throw IllegalArgumentException("Neither donationCenterId nor venue is provided. One must be provided.")
        }
    }
}
