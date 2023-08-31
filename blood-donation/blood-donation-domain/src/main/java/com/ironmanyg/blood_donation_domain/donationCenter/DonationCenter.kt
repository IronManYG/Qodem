package com.ironmanyg.blood_donation_domain.donationCenter

import com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.BloodInventory
import com.ironmanyg.blood_donation_domain.donationCenter.contactInfo.ContactInfo
import com.ironmanyg.blood_donation_domain.donationCenter.operationInfo.OperationInfo
import com.ironmanyg.blood_donation_domain.donationCenter.others.AddressInfo
import com.ironmanyg.blood_donation_domain.donationCenter.others.CampaignInfo
import com.ironmanyg.blood_donation_domain.donationCenter.others.DonationCenterCategory
import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.DonationRecord
import com.ironmanyg.blood_donation_domain.donationCenter.donationRecord.DonationType
import com.ironmanyg.blood_donation_domain.donationCenter.others.NameInfo
import com.ironmanyg.blood_donation_domain.donationCenter.others.Review

/**
 * Represents a blood donation center with its details.
 *
 * @property id Unique identifier for the donation center.
 * @property nameInfo Names of the donation center in different languages.
 * @property addressInfo Detailed address information of the donation center.
 * @property contactInfo Contact details of the donation center.
 * @property reviews List of reviews related to the donation center.
 * @property operationInfo Operational details of the donation center.
 * @property category Category of the donation center.
 * @property availableDonationTypes Types of donations available at the center.
 * @property campaignInfo Information about any ongoing blood donation campaigns.
 * @property bloodInventories List of available blood inventories at the center.
 * @property donationRecords List of donation records associated with the center.
 */
data class DonationCenter(
    val id: Int,
    val nameInfo: NameInfo,
    val addressInfo: AddressInfo,
    val contactInfo: ContactInfo,
    val reviews: List<Review>,
    val operationInfo: OperationInfo,
    val category: DonationCenterCategory,
    val availableDonationTypes: List<DonationType>,
    val campaignInfo: CampaignInfo?,
    val bloodInventories: List<BloodInventory>,
    val donationRecords: List<DonationRecord>,
)
