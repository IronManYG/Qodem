package com.ironmanyg.community_domain

/**
 * Represents a discussion or thread within the community.
 *
 * @property id Unique identifier for the discussion.
 * @property title Title or subject of the discussion.
 * @property content Main content or body of the discussion.
 * @property authorId Identifier of the donor who initiated the discussion.
 * @property creationDate Timestamp (in milliseconds since epoch) indicating when the discussion was initiated.
 * @property comments List of comments or responses associated with this discussion. Defaults to an empty list.
 */
data class Discussion(
    val id: Int,
    val title: String,
    val content: String,
    val authorId: Int,
    val creationDate: Long,
    val comments: List<Comment> = emptyList()
)
