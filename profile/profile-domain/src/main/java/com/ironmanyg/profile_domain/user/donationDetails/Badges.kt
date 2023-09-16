package com.ironmanyg.profile_domain.user.donationDetails

/**
 * The `Badge` enum class is utilized to categorize and award badges to blood donors based on their
 * specific contributions and achievements in the blood donation community. Each enum constant represents
 * a specific badge that a donor can receive.
 */
enum class Badge(val humanReadableName : String) {
    /** Awarded to users who donate blood for the first time. */
    FirstTimeDonor("First Time Donor"),

    /** Awarded to users who donate blood on a regular basis within a specific timeframe. */
    FrequentDonor("Frequent Donor"),

    /** Awarded to users whose blood donation directly contributed to saving a life. */
    LifeSaver("Life Saver"),

    /** Awarded to users who have made a significant impact on their local community by donating blood. */
    CommunityHero("Community Hero"),

    /** Awarded to users with rare blood types who regularly donate to help others with similar blood types. */
    BloodGroupChampion("Blood Group Champion"),

    /** Awarded to users who donate double red blood cells, helping patients in need of specific components. */
    DoubleRedDonor("Double Red Donor"),

    /** Awarded to users who donate platelets, which are crucial for patients with clotting disorders. */
    PlateletDonor("Platelet Donor"),

    /** Awarded to users with a high number of blood donations, signifying their dedication to the cause. */
    Hematologist("Hematologist"),

    /** Awarded to users who donate blood during emergency blood drives or critical shortage situations. */
    EmergencyResponder("Emergency Responder"),

    /** Awarded to users who maintain a consistent streak of blood donations over a period of time. */
    DonationStreak("Donation Streak"),

    /** Awarded to users who have collectively donated a gallon (or other significant volume) of blood. */
    GoldenGallon("Golden Gallon"),

    /** Awarded to users who participate in donation drives for charitable causes or disaster relief efforts. */
    BleedForGood("Bleed for Good"),

    /** Awarded to users who actively promote blood donation through social media or community events. */
    DonorAdvocate("Donor Advocate"),

    /** Awarded to users who organize and host successful blood drives in their communities. */
    BloodDriveHost("Blood Drive Host"),

    /** Awarded to users who participate in group donation efforts, encouraging friends, family, and colleagues to donate. */
    TeamPlayer("Team Player"),

    /** Awarded to users who have made a substantial lifetime commitment to blood donation. */
    LifetimeDonorAchievement("Lifetime Donor Achievement"),

    /** Awarded to users who help educate others about the importance and benefits of blood donation. */
    DonationEducator("Donation Educator"),

    /** Awarded to users who participate in virtual blood donation events or campaigns. */
    VirtualDonor("Virtual Donor"),

    /** Awarded to users who engage in public speaking or media appearances to promote blood donation. */
    DonationAmbassador("Donation Ambassador"),

    /** Awarded to users who donate blood internationally or participate in cross-border blood donation efforts. */
    GlobalGiver("Global Giver"),

    /**
     * Unknown badge. This is the default value for the enum constant and should not be used.
     */
    UNKNOWN("Unknown");

    companion object {
        /**
         * Returns the Badge corresponding to the given human-readable name, ignoring case and extra spaces.
         *
         * @param name The human-readable name of the badge.
         * @return The corresponding Badge, or UNKNOWN if no match is found.
         */
        fun fromName(name: String): Badge {
            return values().find { it.humanReadableName.equals(name.trim(), true) } ?: UNKNOWN
        }
    }
}




