package com.ironmanyg.community_domain

/**
 * Represents an administrator or organizer in the community with a specific role.
 *
 * @property donorId Unique identifier of the donor who is assigned an administrative role.
 * @property role Role assigned to the donor, e.g., 'Moderator', 'Event Organizer'.
 * @property sinceDate Timestamp (in milliseconds since epoch) indicating when the donor was assigned the role.
 */
data class Admin(
    val donorId: Int,
    val role: AdminRole,
    val sinceDate: Long
)