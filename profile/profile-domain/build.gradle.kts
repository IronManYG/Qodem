apply(
    from = "$rootDir/library-build.gradle"
)

dependencies {
    "implementation"(project(Modules.blood_donation_domain))
}