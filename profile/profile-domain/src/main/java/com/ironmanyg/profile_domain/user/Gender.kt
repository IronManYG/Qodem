package com.ironmanyg.profile_domain.user

/**
 * Enum class representing different genders a user can identify with.
 */
enum class Gender(val humanReadableName: String) {
    /** Represents the male gender. */
    MALE("Male"),

    /** Represents the female gender. */
    FEMALE("Female"),

    /** Represents a not specified or undisclosed gender. */
    NOT_SPECIFIED("Not Specified");

    companion object {
        /**
         * Returns the Gender enum entry that corresponds to the given human-readable name parameter.
         * The comparison is case-insensitive.
         *
         * @param name A string representation of the gender; it can be "Male", "Female", or any other string.
         * @return The Gender enum entry that corresponds to the given name, or NOT_SPECIFIED if the name does not match any known genders.
         */
        fun fromName(name: String): Gender {
            return values().find { it.humanReadableName.equals(name, true) } ?: NOT_SPECIFIED
        }
    }
}
