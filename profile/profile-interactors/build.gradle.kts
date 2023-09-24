apply(
    from = "$rootDir/library-build.gradle"
)

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.profile_datasource ))
    "implementation"(project(Modules.profile_domain))

    "implementation"(Kotlinx.coroutinesCore) // need for flows

    "implementation"(Ktor.core)
    "implementation"(Ktor.kotlinxSerialization)
}