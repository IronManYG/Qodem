package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.bloodInventory

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.BloodInventory
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodGroup
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.RhFactor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) for Blood Inventory that represents the blood inventory data
 * as it is transferred over the network. It is serializable to facilitate data transfer and maps
 * to the [BloodInventory] domain object.
 *
 * @property id The unique identifier of the blood inventory record.
 * @property donationCenterId The unique identifier of the donation center where the blood inventory is stored.
 * @property bloodType The type of blood as a string which is later parsed to obtain BloodGroup and RhFactor.
 * @property amount The quantity of blood available in terms of the number of units/bags.
 * @property volume The total volume of blood available (in milliliters)..
 */
@Serializable
data class BloodInventoryDto(
    @SerialName("id")
    val id: Int,
    @SerialName("donation_center_id")
    val donationCenterId: Int,
    @SerialName("blood_type")
    val bloodType: String,
    @SerialName("amount")
    val amount: Int,
    @SerialName("volume")
    val volume: Double,
)

/**
 * Converts a [BloodInventoryDto] instance to a [BloodInventory] domain object by mapping
 * each property from DTO to the domain object's properties, including a conversion of
 * string bloodType to separate BloodGroup and RhFactor enums.
 *
 * @return A [BloodInventory] object with data mapped from the [BloodInventoryDto].
 */
fun BloodInventoryDto.toBloodInventory() = BloodInventory(
    id = id,
    donationCenterId = donationCenterId,
    bloodType = BloodType.fromComponents(BloodGroup.valueOf(bloodType.first().toString()),RhFactor.valueOf(bloodType.last().toString())),
    amount = amount,
    volume = volume,
)

