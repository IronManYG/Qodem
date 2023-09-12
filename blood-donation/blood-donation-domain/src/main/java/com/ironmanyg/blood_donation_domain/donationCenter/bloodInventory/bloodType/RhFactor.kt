package com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType

/**
 * Enum class representing the Rh factors.
 *
 * The Rh factor is a protein that can be present on the surface of red blood cells.
 * Most people have the Rh factor (they are Rh positive).
 * But some do not (they are Rh negative).
 *
 * @property symbol The symbol representing the Rh factor; "+" for positive and "-" for negative.
 */
enum class RhFactor(val symbol: String) {

    /**
     * Represents the Rh-positive blood type, indicating the presence of the Rh antigen on the surface of the red blood cells.
     */
    Positive("+"),

    /**
     * Represents the Rh-negative blood type, indicating the absence of the Rh antigen on the surface of the red blood cells.
     */
    Negative("-");

    companion object {

        /**
         * Returns the [RhFactor] corresponding to the provided symbol.
         *
         * @param symbol The symbol of the Rh factor; should be either "+" or "-".
         * @return The [RhFactor] corresponding to the symbol.
         * @throws IllegalArgumentException if the symbol does not correspond to a valid [RhFactor].
         */
        fun fromSymbol(symbol: String): RhFactor {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid Rh factor symbol.")
        }
    }

}
