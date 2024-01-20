package com.ironmanyg.blood_donation_interactors

import com.ironmanyg.blood_donation_datasource.network.BloodDonationService
import com.ironmanyg.blood_donation_interactors.bloodDonationCenters.GetBloodDonationCenters
import com.ironmanyg.core.util.Logger

/**
 * Data class to hold various interactors related to blood donation functionalities.
 *
 * This class is a convenient way to assemble all interactors in one place, providing an easy way to
 * manage them and facilitate their use throughout the app.
 *
 * @property getBloodDonationCenters The interactor responsible for fetching blood donation center data.
 */
data class BloodDonationInteractors(
    val getBloodDonationCenters: GetBloodDonationCenters,
    // TODO: In future, add other interactors here to expand the functionalities and keep all interactors centralized.
) {
    companion object Factory {

        /**
         * Factory method to build [BloodDonationInteractors] instance with necessary dependencies.
         *
         * @param logger The logger utility to be used by the interactors for logging errors and other important information.
         * @return A newly created [BloodDonationInteractors] instance with the necessary dependencies injected.
         */
        fun build(logger: Logger): BloodDonationInteractors {
            val bloodDonationService = BloodDonationService.build()
            return BloodDonationInteractors(
                getBloodDonationCenters = GetBloodDonationCenters(
                    service = bloodDonationService,
                    logger = logger
                ),
            )
        }
    }
}
