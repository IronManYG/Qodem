package com.ironmanyg.community_domain

/**
 * Represents a comment or reply within a discussion.
 *
 * @property id Unique identifier for the comment.
 * @property content Textual content or body of the comment.
 * @property authorId Identifier of the donor who posted the comment.
 * @property creationDate Timestamp (in milliseconds since epoch) marking when the comment was made.
 */
data class Comment(
    val id: Int,
    val content: String,
    val authorId: Int,
    val creationDate: Long
)
