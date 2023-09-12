apply(
    from = "$rootDir/library-build.gradle"
)

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.blood_donation_datasource))
    "implementation"(project(Modules.blood_donation_domain))

    "implementation"(Kotlinx.coroutinesCore) // need for flows

    "implementation"(Ktor.core)
    "implementation"(Ktor.kotlinxSerialization)
}