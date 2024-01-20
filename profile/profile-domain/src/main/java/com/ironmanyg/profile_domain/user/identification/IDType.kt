package com.ironmanyg.profile_domain.user.identification

/**
 * Represents the types of identification documents that a user can provide.
 *
 * This enum class is used to specify the type of identification document that a user has provided.
 * It can be used in various parts of the application where user identification is required.
 *
 * @property Passport Represents a passport document.
 * @property NationalID Represents a national identification card.
 * @property UNKNOWN Represents an unknown identification document.
 */
enum class IDType {
    /**
     * Represents a passport document.
     *
     * A passport is a travel document, usually issued by a country's government to its citizens,
     * that certifies the identity and nationality of its holder primarily for the purpose of international travel.
     */
    Passport,

    /**
     * Represents a national identification card.
     *
     * A national identification card is an identity document issued by a government to its citizens
     * for the purpose of verifying the holder's identity within the country.
     */
    NationalID,

    /**
     * Represents an unknown identification document.
     *
     * This is used to prevent application crashes due to invalid data.
     */
    UNKNOWN;

    companion object {
        /**
         * Function to map a string representation of IDType to its respective enum constant.
         *
         * This function facilitates the conversion of IDType received from the network layer as a string to its corresponding enum representation, helping in maintaining type safety.
         *
         * @param name The string representation of IDType.
         * @return The corresponding [IDType] enum constant. Returns [IDType.UNKNOWN] for unmatched names to prevent application crashes due to invalid data.
         */
        fun fromName(name: String): IDType {
            return when (name) {
                "Passport" -> Passport
                "NationalID" -> NationalID
                else -> UNKNOWN
            }
        }
    }
}