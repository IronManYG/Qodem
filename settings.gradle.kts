pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Qodem"
include(":app")

include(":authentication")
include(":authentication:authentication-datasource")
include(":authentication:authentication-datasource-test")
include(":authentication:authentication-domain")
include(":authentication:authentication-interactors")
include(":authentication:ui-login")
include(":authentication:ui-signup")

include(":blood-donation")
include(":blood-donation:blood-donation-datasource")
include(":blood-donation:blood-donation-datasource-test")
include(":blood-donation:blood-donation-domain")
include(":blood-donation:blood-donation-interactors")
include(":blood-donation:ui-CentersDrivesList")
include(":blood-donation:ui-centersDrivesMap")
include(":blood-donation:ui-eligibilityChecker")
include(":blood-donation:ui-scheduleAppointments")
include(":blood-donation:ui-appointmentsDetail")
include(":blood-donation:ui-donationHistory")
include(":blood-donation:ui-donationVerify")
include(":blood-donation:ui-findDonor")
include(":blood-donation:ui-bloodInventory")
include(":blood-donation:ui-feedbackAndRatings")
include(":blood-donation:ui-emergencyServices")

include(":core")
include(":core-ui")
include(":constants")
include(":components")

include(":community")
include(":community:community-datasource")
include(":community:community-datasource-test")
include(":community:community-domain")
include(":community:community-interactors")
include(":community:ui-community")

include(":onboarding")
include(":onboarding:ui-onboarding")

include(":profile")
include(":profile:profile-datasource")
include(":profile:profile-datasource-test")
include(":profile:profile-domain")
include(":profile:profile-interactors")
include(":profile:ui-profile")

include(":settings")
include(":settings:ui-settings")
