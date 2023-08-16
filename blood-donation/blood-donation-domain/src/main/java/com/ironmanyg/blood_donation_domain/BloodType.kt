package com.ironmanyg.blood_donation_domain

/**
 * Represents a blood type with properties such as blood group, Rh factor, and compatibility for blood donation and transfusion.
 *
 * @property bloodGroup The blood group of the blood type (O, A, B, or AB).
 * @property rhFactor The Rh factor of the blood type (Positive or Negative).
 * @property receiveFrom A list of blood types that this blood type can receive blood from.
 * @property donateTo A list of blood types that this blood type can donate blood to.
 */
sealed class BloodType(
    val bloodGroup: BloodGroup,
    val rhFactor: RhFactor,
    val receiveFrom: List<BloodType>,
    val donateTo: List<BloodType>
) {
    // Data objects representing the eight possible blood types.
    data object OPositive : BloodType(
        bloodGroup = BloodGroup.O,
        rhFactor = RhFactor.Positive,
        receiveFrom = listOf(OPositive, ONegative),
        donateTo = listOf(OPositive, APositive, BPositive, ABPositive)
    )

    data object ONegative : BloodType(
        bloodGroup = BloodGroup.O,
        rhFactor = RhFactor.Negative,
        receiveFrom = listOf(ONegative),
        donateTo = listOf(
            OPositive,
            ONegative,
            APositive,
            ANegative,
            BPositive,
            BNegative,
            ABPositive,
            ABNegative
        )
    )

    data object APositive : BloodType(
        bloodGroup = BloodGroup.A,
        rhFactor = RhFactor.Positive,
        receiveFrom = listOf(APositive, ANegative, OPositive, ONegative),
        donateTo = listOf(APositive, ABPositive)
    )

    data object ANegative : BloodType(
        bloodGroup = BloodGroup.A,
        rhFactor = RhFactor.Negative,
        receiveFrom = listOf(ANegative, ONegative),
        donateTo = listOf(APositive, ANegative, ABPositive, ABNegative)
    )

    data object BPositive : BloodType(
        bloodGroup = BloodGroup.B,
        rhFactor = RhFactor.Positive,
        receiveFrom = listOf(BPositive, BNegative, OPositive, ONegative),
        donateTo = listOf(BPositive, ABPositive)
    )

    data object BNegative : BloodType(
        bloodGroup = BloodGroup.B,
        rhFactor = RhFactor.Negative,
        receiveFrom = listOf(BNegative, ONegative),
        donateTo = listOf(BPositive, BNegative, ABPositive, ABNegative)
    )

    data object ABPositive : BloodType(
        bloodGroup = BloodGroup.AB,
        rhFactor = RhFactor.Positive,
        receiveFrom = listOf(
            OPositive,
            ONegative,
            APositive,
            ANegative,
            BPositive,
            BNegative,
            ABPositive,
            ABNegative
        ),
        donateTo = listOf(ABPositive)
    )

    data object ABNegative : BloodType(
        bloodGroup = BloodGroup.AB,
        rhFactor = RhFactor.Negative,
        receiveFrom = listOf(ABNegative, ANegative, BNegative, ONegative),
        donateTo = listOf(ABPositive, ABNegative)
    )
}

/**
 * Converts a blood group and Rh factor to the corresponding BloodType object.
 *
 * @param bloodGroup The blood group of the blood type (O, A, B, or AB).
 * @param rhFactor The Rh factor of the blood type (Positive or Negative).
 * @return The corresponding BloodType object.
 */
fun fromName(bloodGroup: BloodGroup, rhFactor: RhFactor): BloodType {
    return when (bloodGroup) {
        BloodGroup.O -> when (rhFactor) {
            RhFactor.Positive -> BloodType.OPositive
            RhFactor.Negative -> BloodType.ONegative
        }

        BloodGroup.A -> when (rhFactor) {
            RhFactor.Positive -> BloodType.APositive
            RhFactor.Negative -> BloodType.ANegative
        }

        BloodGroup.B -> when (rhFactor) {
            RhFactor.Positive -> BloodType.BPositive
            RhFactor.Negative -> BloodType.BNegative
        }

        BloodGroup.AB -> when (rhFactor) {
           RhFactor.Positive -> BloodType.ABPositive
            RhFactor.Negative -> BloodType.ABNegative
        }
    }
}

/**
 * Converts a BloodType object to its string representation.
 *
 * @param bloodType The BloodType object to convert.
 * @return The string representation of the blood type.
 */
fun toName(bloodType: BloodType): String {
    return "${bloodType.bloodGroup}${if (bloodType.rhFactor == RhFactor.Positive) "+" else "-"}"
}

/**
 * Enum class representing the blood groups.
 */
enum class BloodGroup { O, A, B, AB }

/**
 * Enum class representing the Rh factors.
 */
enum class RhFactor { Positive, Negative }
