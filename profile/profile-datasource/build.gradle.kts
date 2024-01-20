apply(
    from = "$rootDir/library-build.gradle"
)

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.profile_domain))
    "implementation"(project(Modules.blood_donation_domain))
    "implementation"(project(Modules.blood_donation_datasource))

    "implementation"(Ktor.core)
    "implementation"(Ktor.contentNegotiation)
    "implementation"(Ktor.kotlinxSerialization)
    "implementation"(Ktor.android)
}