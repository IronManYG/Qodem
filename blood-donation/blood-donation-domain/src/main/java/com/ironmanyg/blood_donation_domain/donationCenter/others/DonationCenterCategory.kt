package com.ironmanyg.blood_donation_domain.donationCenter.others

/**
 * Represents the different categories of blood donation centers.
 *
 * @property name The name of the donation center category.
 */
sealed class DonationCenterCategory(val name: String) {

    /**
     * Represents a large, centralized facility that collects, stores, and distributes blood products
     * to hospitals and other healthcare organizations.
     */
    data object BloodBank : DonationCenterCategory("Blood Bank")

    /**
     * Represents a smaller facility that collects blood from donors.
     */
    data object BloodCollectionCenter : DonationCenterCategory("Blood Collection Center")

    /**
     * Represents a temporary blood donation event that is held at schools, workplaces, and other community locations.
     *
     * @property startDate The start date of the mobile blood drive event.
     * @property endDate The end date of the mobile blood drive event.
     */
    data class MobileBloodDrive(val startDate: Long, val endDate: Long) : DonationCenterCategory("Mobile Blood Drive")

    /**
     * Represents a blood bank that is located within a hospital.
     */
    data object HospitalBloodBank : DonationCenterCategory("Hospital Blood Bank")

    /**
     * Represents a blood bank that is operated by the military.
     */
    data object MilitaryBloodBank : DonationCenterCategory("Military Blood Bank")
}
