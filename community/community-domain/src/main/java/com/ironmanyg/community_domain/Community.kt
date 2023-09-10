package com.ironmanyg.community_domain

/**
 * Represents a blood donation community where donors can come together for events, discussions, and more.
 *
 * @property id Unique identifier for the community.
 * @property name Name of the community.
 * @property description Description or mission statement of the community.
 * @property members Set of member IDs associated with the community.
 * @property eventIds Set of event IDs associated with the community.
 * @property discussions Discussions or threads within the community. Defaults to an empty list.
 * @property adminList Administrators responsible for managing the community.
 * @property creationDate Timestamp (in milliseconds since epoch) indicating when the community was established.
 * @property coverImageURL URL for the community's cover image or logo in a standard format (e.g., "https://...").
 * @property rules Guidelines or code of conduct for the community members.
 */
data class Community(
    val id: Int,
    val name: String,
    val description: String,
    val members: Set<Int>,
    val eventIds: Set<Int>,
    val discussions: List<Discussion> = emptyList(),
    val adminList: List<Admin>,
    val creationDate: Long,
    val coverImageURL: String?,
    val rules: List<String>
)
