package com.ironmanyg.blood_donation_datasource.network.model.donationCenter

import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.bloodInventory.BloodInventoryDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.bloodInventory.toBloodInventory
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.contactInfoDto.ContactInfoDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.contactInfoDto.toContactInfo
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.donationRecord.DonationRecordDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.donationRecord.toDonationRecord
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto.OperationInfoDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.operationInfoDto.toOperationInfo
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.AddressInfoDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.CampaignInfoDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.NameInfoDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.ReviewDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.toAddressInfo
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.toCampaignInfo
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.toNameInfo
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others.toReview
import com.ironmanyg.blood_donation_domain.donationCenter.DonationCenter
import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.fromNameToDonationType
import com.ironmanyg.blood_donation_domain.donationCenter.others.fromNameToDonationCenterCategory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) for Donation Center that encompasses all the relevant details of a donation center
 * as it is handled in the network layer. This DTO maps directly to the [DonationCenter] domain object.
 *
 * @property id The unique identifier for the donation center.
 * @property nameInfo Information about the name of the donation center.
 * @property addressInfo Detailed address information of the donation center.
 * @property contactInfo Contact details of the donation center.
 * @property reviews A list of reviews related to the donation center.
 * @property operationInfo Operational details of the donation center.
 * @property category The category that the donation center falls under.
 * @property availableDonationTypes A list of available donation types at the donation center.
 * @property campaignInfo Information regarding campaigns hosted by the donation center.
 * @property bloodInventories Inventory details regarding various blood groups and types available at the center.
 * @property donationRecords A list of donation records associated with the donation center.
 */
@Serializable
data class DonationCenterDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name_info")
    val nameInfo: NameInfoDto,
    @SerialName("address_info")
    val addressInfo: AddressInfoDto,
    @SerialName("contact_info")
    val contactInfo: ContactInfoDto,
    @SerialName("reviews")
    val reviews: List<ReviewDto>,
    @SerialName("operation_info")
    val operationInfo: OperationInfoDto,
    @SerialName("category")
    val category: String,
    @SerialName("donation_types")
    val availableDonationTypes: List<String>,
    @SerialName("campaign_info")
    val campaignInfo: CampaignInfoDto,
    @SerialName("bloodInventories")
    val bloodInventories: List<BloodInventoryDto>,
    @SerialName("donationRecords")
    val donationRecords: List<DonationRecordDto>,
)

/**
 * Extension function to convert a [DonationCenterDto] instance to a [DonationCenter] domain
 * object. This function is responsible for mapping the properties from the DTO to the domain object,
 * including the conversion of nested DTO objects to their corresponding domain objects.
 *
 * @return A [DonationCenter] object with data mapped from the [DonationCenterDto].
 */
fun DonationCenterDto.toDonationCenter() = DonationCenter(
    id = id,
    nameInfo = nameInfo.toNameInfo(),
    addressInfo = addressInfo.toAddressInfo(),
    contactInfo = contactInfo.toContactInfo(),
    reviews = reviews.map { it.toReview() },
    operationInfo = operationInfo.toOperationInfo(),
    category = fromNameToDonationCenterCategory(category),
    availableDonationTypes = availableDonationTypes.map { fromNameToDonationType(it) },
    campaignInfo = campaignInfo.toCampaignInfo(),
    bloodInventories = bloodInventories.map { it.toBloodInventory() },
    donationRecords = donationRecords.map { it.toDonationRecord() },
)

