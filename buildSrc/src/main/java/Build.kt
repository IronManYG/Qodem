object Build {
    private const val androidBuildToolsVersion = "8.1.0"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.hiltVersion}"

    const val sqlDelightGradlePlugin = "app.cash.sqldelight:gradle-plugin:${SqlDelight.version}"

    private const val googleServicesVersion = "4.3.15"
    const val googleServices = "com.google.gms:google-services:$googleServicesVersion"
}