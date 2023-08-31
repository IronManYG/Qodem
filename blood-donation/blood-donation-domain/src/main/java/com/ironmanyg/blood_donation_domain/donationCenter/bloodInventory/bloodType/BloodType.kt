package com.ironmanyg.blood_donation_domain.donationCenter.bloodInventory.bloodType

/**
 * Enum representation of blood types, considering both the blood group (O, A, B, AB) and the Rh factor (Positive, Negative).
 *
 * Each BloodType provides properties to determine which blood types it can receive from or donate to.
 *
 * @property bloodGroup The blood group of the blood type (O, A, B, or AB).
 * @property rhFactor The Rh factor of the blood type (Positive or Negative).
 */
enum class BloodType(val bloodGroup: BloodGroup, val rhFactor: RhFactor) {
    OPositive(BloodGroup.O, RhFactor.Positive),
    ONegative(BloodGroup.O, RhFactor.Negative),
    APositive(BloodGroup.A, RhFactor.Positive),
    ANegative(BloodGroup.A, RhFactor.Negative),
    BPositive(BloodGroup.B, RhFactor.Positive),
    BNegative(BloodGroup.B, RhFactor.Negative),
    ABPositive(BloodGroup.AB, RhFactor.Positive),
    ABNegative(BloodGroup.AB, RhFactor.Negative);

    /**
     * Returns a set of BloodTypes that this blood type can receive blood from.
     * Derived based on universal blood transfusion compatibility rules.
     */
    val receiveFrom: Set<BloodType>
        get() = when (this) {
            OPositive -> setOf(OPositive, ONegative)
            ONegative -> setOf(ONegative)
            APositive -> setOf(APositive, ANegative, OPositive, ONegative)
            ANegative -> setOf(ANegative, ONegative)
            BPositive -> setOf(BPositive, BNegative, OPositive, ONegative)
            BNegative -> setOf(BNegative, ONegative)
            ABPositive -> values().toSet()  // Can receive from any type
            ABNegative -> setOf(ABNegative, ANegative, BNegative, ONegative)
        }

    /**
     * Returns a set of BloodTypes that this blood type can donate blood to.
     * Derived based on universal blood transfusion compatibility rules.
     */
    val donateTo: Set<BloodType>
        get() = when (this) {
            OPositive -> setOf(OPositive, APositive, BPositive, ABPositive)
            ONegative -> values().toSet()  // Can donate to any type
            APositive -> setOf(APositive, ABPositive)
            ANegative -> setOf(APositive, ANegative, ABPositive, ABNegative)
            BPositive -> setOf(BPositive, ABPositive)
            BNegative -> setOf(BPositive, BNegative, ABPositive, ABNegative)
            ABPositive -> setOf(ABPositive)
            ABNegative -> setOf(ABPositive, ABNegative)
        }

    companion object {
        /**
         * Converts a blood group and Rh factor to the corresponding BloodType.
         *
         * @param bloodGroup The blood group of the blood type (O, A, B, or AB).
         * @param rhFactor The Rh factor of the blood type (Positive or Negative).
         * @return The corresponding BloodType.
         */
        fun fromComponents(bloodGroup: BloodGroup, rhFactor: RhFactor): BloodType {
            return values().first { it.bloodGroup == bloodGroup && it.rhFactor == rhFactor }
        }

        /**
         * Converts a BloodType to its string representation.
         *
         * @param bloodType The BloodType object to convert.
         * @return The string representation of the blood type, e.g., "A+".
         */
        fun toBloodTypeString(bloodType: BloodType): String {
            return "${bloodType.bloodGroup}${if (bloodType.rhFactor == RhFactor.Positive) "+" else "-"}"
        }
    }
}
