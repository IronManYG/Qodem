package com.ironmanyg.blood_donation_domain.donationCenter.operationInfo

/**
 * Data class representing the working hours of the blood donation center.
 *
 * This class helps in maintaining a structured representation of the start and end time of the operation hours.
 *
 * @property startTime An instance of [SimpleTime] representing the start time of the working hours.
 * @property endTime An instance of [SimpleTime] representing the end time of the working hours.
 */
data class WorkingHours(
    val startTime: SimpleTime,
    val endTime: SimpleTime
)
