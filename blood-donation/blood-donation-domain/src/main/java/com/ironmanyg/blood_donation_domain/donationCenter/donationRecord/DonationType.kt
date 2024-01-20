package com.ironmanyg.blood_donation_domain.donationCenter.donationRecord

/**
 * Represents different types of blood donations with associated descriptions.
 *
 * The types detailed within this sealed class cover the common varieties of blood donations,
 * each with its respective utility in medical treatments.
 *
 * @property description A brief descriptor of the donation type.
 */
sealed class DonationType(val description: String) {

    /**
     * Whole blood donation is the most common type of blood donation. During a whole blood donation,
     * donors provide all components of their blood, including red blood cells, plasma, and platelets.
     * Whole blood donations are primarily used for conditions like trauma, surgery, and anemia.
     */
    data object WholeBlood : DonationType("Whole blood")

    /**
     * Platelet donation is specific to the platelet component of blood. These are cells responsible
     * for clotting. Donations of this kind are beneficial for patients with bleeding disorders such
     * as leukemia and cancer, as well as for those undergoing surgery or trauma recovery.
     */
    data object Platelet : DonationType("Platelet")

    /**
     * Plasma donation targets the liquid portion of blood. Rich in proteins, plasma aids in clotting,
     * fights infections, and delivers oxygen to tissues. Donations of plasma assist patients with
     * conditions ranging from burns and shock to hemophilia.
     */
    data object Plasma : DonationType("Plasma")

    /**
     * Double red cell donation involves donors providing two units of red blood cells but only one
     * unit each of plasma and platelets. This type of donation primarily benefits patients with
     * anemia-related conditions such as sickle cell disease and thalassemia.
     */
    data object DoubleRedCell : DonationType("Double red cell")
}

/**
 * Converts a donation type name to its respective [DonationType] object.
 *
 * @param name The name of the donation type.
 * @return The [DonationType] object associated with the given name.
 */
fun fromNameToDonationType(name: String): DonationType {
    return when (name) {
        "Whole blood" -> DonationType.WholeBlood
        "Platelet" -> DonationType.Platelet
        "Plasma" -> DonationType.Plasma
        "Double red cell" -> DonationType.DoubleRedCell
        else -> DonationType.WholeBlood
    }
}
