package com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType

/**
 * Represents the blood inventory details of a donation center.
 *
 * @property id Unique identifier for the blood inventory.
 * @property donationCenterId ID of the associated donation center.
 * @property bloodType Type of the blood in the inventory.
 * @property amount Number of blood units available.
 * @property volume Volume of blood available (in milliliters).
 */
data class BloodInventory(
    val id: Int,
    val donationCenterId: Int,
    val bloodType: BloodType,
    val amount: Int,
    val volume: Double,
)