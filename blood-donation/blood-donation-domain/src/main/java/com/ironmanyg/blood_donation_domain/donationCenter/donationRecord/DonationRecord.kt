package com.ironmanyg.blood_donation_domain.donationCenter.donationRecord

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType

/**
 * Represents a record of a blood donation.
 *
 * This data class is used to store and manage information about blood donations
 * in a blood bank or donation center. It includes details such as the donor's
 * ID, the donation center's ID, the blood type, the type of donation, the
 * purpose of the donation, the amount and volume of blood donated, and the
 * donation timestamp.
 *
 * @property id The unique identifier of the donation record.
 * @property donorId The unique identifier of the donor.
 * @property donationCenterId The unique identifier of the donation center where the donation took place.
 * @property bloodType The blood type of the donor.
 * @property donationType The type of donation (e.g., whole blood, plasma, platelets).
 * @property donationPurpose The purpose of the donation (e.g., directed, voluntary).
 * @property amount The amount of blood donated.
 * @property volume The volume of blood donated in milliliters.
 * @property active Indicates whether the donation record is active or not.
 * @property authenticated Indicates whether the donation record has been authenticated or not.
 * @property donationDateTimeStamp The timestamp of the donation date and time.
 */
data class DonationRecord(
    val id: Int,
    val donorId: Int,
    val donationCenterId: Int,
    val bloodType: BloodType,
    val donationType: DonationType,
    val donationPurpose: DonationPurpose,
    val amount: Int,
    val volume: Double,
    var active: Boolean,
    var authenticated: Boolean,
    var donationDateTimeStamp: Long
)
