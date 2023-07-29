object Compose {
    private const val activityComposeVersion = "1.7.2"
    const val activity = "androidx.activity:activity-compose:$activityComposeVersion"

    const val composeCompilerVersion = "1.5.0"
    const val composeVersion = "1.4.3"
    private const val material3Version = "1.1.1"
    private const val lifecycleVersion = "2.6.1"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val graphics = "androidx.compose.ui:ui-graphics:$composeVersion"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
    const val material3 = "androidx.compose.material3:material3:$material3Version"
    const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val iconsExtended = "androidx.compose.material:material-icons-extended:$composeVersion"
    const val viewBinding ="androidx.compose.ui:ui-viewbinding:$composeVersion"

    private const val navigationVersion = "2.6.0"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
}

object ComposeTest {
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
}