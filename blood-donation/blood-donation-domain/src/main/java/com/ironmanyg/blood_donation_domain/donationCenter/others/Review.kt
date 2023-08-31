package com.ironmanyg.blood_donation_domain.donationCenter.others

/**
 * Represents a review given by a donor for a donation center.
 *
 * @property id Unique identifier for the review.
 * @property donorId ID of the donor who gave the review.
 * @property donationCenterId ID of the associated donation center.
 * @property isAnonymous Indicates if the review is anonymous.
 * @property rating Rating given by the donor (out of 5, typically).
 * @property comment Optional comment provided by the donor.
 * @property date Date when the review was given (in milliseconds since epoch).
 */
data class Review(
    val id: Int,
    val donorId: Int,
    val donationCenterId: Int,
    val isAnonymous: Boolean,
    val rating: Int,
    val comment: String?,
    val date: Long,
)