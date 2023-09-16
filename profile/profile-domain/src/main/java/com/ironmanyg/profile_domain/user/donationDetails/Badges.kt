package com.ironmanyg.profile_domain.user.donationDetails

/**
 * The `Badge` enum class is utilized to categorize and award badges to blood donors based on their
 * specific contributions and achievements in the blood donation community. Each enum constant represents
 * a specific badge that a donor can receive.
 */
enum class Badge {
    /** Awarded to users who donate blood for the first time. */
    FirstTimeDonor,

    /** Awarded to users who donate blood on a regular basis within a specific timeframe. */
    FrequentDonor,

    /** Awarded to users whose blood donation directly contributed to saving a life. */
    LifeSaver,

    /** Awarded to users who have made a significant impact on their local community by donating blood. */
    CommunityHero,

    /** Awarded to users with rare blood types who regularly donate to help others with similar blood types. */
    BloodGroupChampion,

    /** Awarded to users who donate double red blood cells, helping patients in need of specific components. */
    DoubleRedDonor,

    /** Awarded to users who donate platelets, which are crucial for patients with clotting disorders. */
    PlateletDonor,

    /** Awarded to users with a high number of blood donations, signifying their dedication to the cause. */
    Hematologist,

    /** Awarded to users who donate blood during emergency blood drives or critical shortage situations. */
    EmergencyResponder,

    /** Awarded to users who maintain a consistent streak of blood donations over a period of time. */
    DonationStreak,

    /** Awarded to users who have collectively donated a gallon (or other significant volume) of blood. */
    GoldenGallon,

    /** Awarded to users who participate in donation drives for charitable causes or disaster relief efforts. */
    BleedForGood,

    /** Awarded to users who actively promote blood donation through social media or community events. */
    DonorAdvocate,

    /** Awarded to users who organize and host successful blood drives in their communities. */
    BloodDriveHost,

    /** Awarded to users who participate in group donation efforts, encouraging friends, family, and colleagues to donate. */
    TeamPlayer,

    /** Awarded to users who have made a substantial lifetime commitment to blood donation. */
    LifetimeDonorAchievement,

    /** Awarded to users who help educate others about the importance and benefits of blood donation. */
    DonationEducator,

    /** Awarded to users who participate in virtual blood donation events or campaigns. */
    VirtualDonor,

    /** Awarded to users who engage in public speaking or media appearances to promote blood donation. */
    DonationAmbassador,

    /** Awarded to users who donate blood internationally or participate in cross-border blood donation efforts. */
    GlobalGiver,

    /**
     * Unknown badge. This is the default value for the enum constant and should not be used.
     */
    UNKNOWN;

    companion object {

        /**
         * A utility function to get a Badge enum entry from its name.
         * The name parameter is the String representation of the badge which is to be converted to a Badge enum type.
         *
         * @param name the name of the badge in a human-readable format.
         * @return the corresponding Badge enum entry, or UNKNOWN if the name does not match any known badges.
         */
        fun fromName(name: String) :Badge {
            return when(name) {
                "First time donor" -> FirstTimeDonor
                "Frequent donor" -> FrequentDonor
                "Life saver" -> LifeSaver
                "Community hero" -> CommunityHero
                "Blood group champion" -> BloodGroupChampion
                "Double redDonor" -> DoubleRedDonor
                "Platelet donor" -> PlateletDonor
                "Hematologist" -> Hematologist
                "Emergency responder" -> EmergencyResponder
                "Donation streak" -> DonationStreak
                "Golden gallon" -> GoldenGallon
                "Bleed for good" -> BleedForGood
                "Donor advocate" -> DonorAdvocate
                "Blood drive host" -> BloodDriveHost
                "Team player" -> TeamPlayer
                "Lifetime donor achievement" -> LifetimeDonorAchievement
                "Donation educator" -> DonationEducator
                "Virtual donor" -> VirtualDonor
                "Donation ambassador" -> DonationAmbassador
                "Global giver" -> GlobalGiver
                else -> UNKNOWN
            }
        }
    }
}




