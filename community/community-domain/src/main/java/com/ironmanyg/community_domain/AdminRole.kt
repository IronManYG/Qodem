package com.ironmanyg.community_domain

/**
 * Defines the various roles an administrator or organizer can hold within the community.
 *
 * The roles determine the capabilities and responsibilities of an admin within the blood donation community.
 * For example:
 * - `MODERATOR` might be responsible for overseeing discussions and ensuring they adhere to community guidelines.
 * - `EVENT_ORGANIZER` could be responsible for setting up and coordinating blood donation events.
 *
 * Additional roles can be added as the community's needs evolve.
 */
enum class AdminRole {
    /** Represents a moderator role, typically responsible for overseeing and moderating discussions. */
    MODERATOR,

    /** Represents an event organizer role, responsible for coordinating and managing blood donation events. */
    EVENT_ORGANIZER

    //... other roles can be added here as required
}



