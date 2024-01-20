package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto

import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.Slot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an individual slot within a time slot.
 *
 * @property id Unique identifier for the slot.
 * @property parentId ID of the parent time slot.
 * @property isAvailable Indicates if the slot is available for booking.
 * @property donorLimit Maximum number of donors that can be accommodated in this slot.
 */
@Serializable
data class SlotDto(
    @SerialName("id")
    val id: Int,
    @SerialName("parent_id")
    val parentId: Int,
    @SerialName("is_available")
    val isAvailable: Boolean,
    @SerialName("donor_limit")
    val donorLimit: Int,
)

/**
 * Converts a [SlotDto] to a [Slot].
 */
fun SlotDto.toSlot() = Slot(
    id = id,
    parentId = parentId,
    isAvailable = isAvailable,
    donorLimit = donorLimit
)

