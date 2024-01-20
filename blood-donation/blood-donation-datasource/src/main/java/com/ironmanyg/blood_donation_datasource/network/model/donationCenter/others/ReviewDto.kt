package com.ironmanyg.blood_donation_datasource.network.model.donationCenter.others

import com.ironmanyg.blood_donation_domain.donationCenter.others.Review
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
@Serializable
data class ReviewDto(
    @SerialName("id")
    val id: Int,
    @SerialName("donor_id")
    val donorId: Int,
    @SerialName("donation_center_id")
    val donationCenterId: Int,
    @SerialName("is_anonymous")
    val isAnonymous: Boolean,
    @SerialName("rating")
    val rating: Int,
    @SerialName("comment")
    val comment: String?,
    @SerialName("date")
    val date: Long,
)

/**
 * Converts a [ReviewDto] to a [Review].
 */
fun ReviewDto.toReview() = Review(
    id = id,
    donorId = donorId,
    donationCenterId = donationCenterId,
    isAnonymous = isAnonymous,
    rating = rating,
    comment = comment,
    date = date
)