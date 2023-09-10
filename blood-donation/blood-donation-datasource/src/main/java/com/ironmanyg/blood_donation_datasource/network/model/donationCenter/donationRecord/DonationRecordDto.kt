package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.donationRecord

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodGroup
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.BloodType
import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType.RhFactor
import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.DonationRecord
import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.fromNameToDonationPurpose
import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.fromNameToDonationType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) for Donation Record representing the details related to a
 * specific blood donation record as it is transferred over the network. This DTO maps directly
 * to the [DonationRecord] domain object.
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
@Serializable
data class DonationRecordDto(
    @SerialName("id")
    val id: Int,
    @SerialName("donor_id")
    val donorId: Int,
    @SerialName("donation_center_id")
    val donationCenterId: Int,
    @SerialName("blood_type")
    val bloodType: String,
    @SerialName("donation_type")
    val donationType: String,
    @SerialName("donation_purpose")
    val donationPurpose: String,
    @SerialName("amount")
    val amount: Int,
    @SerialName("volume")
    val volume: Double,
    @SerialName("active")
    var active: Boolean,
    @SerialName("authenticated")
    var authenticated: Boolean,
    @SerialName("donation_date_timeStamp")
    var donationDateTimeStamp: Long

)

/**
 * Extension function to convert a [DonationRecordDto] instance to a [DonationRecord] domain
 * object. This function is used to map the properties from the DTO to the domain object,
 * including parsing strings to their respective enum values in the domain layer.
 *
 * @return A [DonationRecord] object with data mapped from the [DonationRecordDto].
 */
fun DonationRecordDto.toDonationRecord() = DonationRecord(
    id = id,
    donorId = donorId,
    donationCenterId = donationCenterId,
    bloodType = BloodType.fromComponents(
        BloodGroup.valueOf(bloodType.first().toString()),
        RhFactor.valueOf(bloodType.last().toString())
    ),
    donationType = fromNameToDonationType(donationType),
    donationPurpose = fromNameToDonationPurpose(donationPurpose),
    amount = amount,
    volume = volume,
    active = active,
    authenticated = authenticated,
    donationDateTimeStamp = donationDateTimeStamp
)
