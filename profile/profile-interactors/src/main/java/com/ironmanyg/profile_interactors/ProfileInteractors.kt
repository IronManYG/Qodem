package com.ironmanyg.profile_interactors

import com.ironmanyg.core.util.Logger
import com.ironmanyg.profile_datasource.network.ProfileService

/**
 * Data class to hold various interactors related to profile functionalities.
 *
 * This class is a convenient way to assemble all interactors in one place, providing an easy way to
 * manage them and facilitate their use throughout the app.
 *
 * @property getUserProfile The interactor responsible for fetching user profile data.
 */
class ProfileInteractors(
    val getUserProfile: GetUserProfile,
    // TODO: In future, add other interactors here to expand the functionalities and keep all interactors centralized.
) {

    companion object Factory {

        /**
         * Factory method to build [ProfileInteractors] instance with necessary dependencies.
         *
         * @param logger The logger utility to be used by the interactors for logging errors and other important information.
         * @return A newly created [ProfileInteractors] instance with the necessary dependencies injected.
         */
        fun build(logger: Logger): ProfileInteractors {
            val profileService = ProfileService.build()
            return ProfileInteractors(
                getUserProfile = GetUserProfile(
                    service = profileService,
                    logger = logger
                ),
            )
        }
    }
}