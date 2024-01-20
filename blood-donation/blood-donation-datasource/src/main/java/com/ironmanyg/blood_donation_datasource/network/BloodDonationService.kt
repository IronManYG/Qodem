package com.ironmanyg.blood_donation_datasource.network

import com.ironmanyg.blood_donation_domain.donationCenter.DonationCenter
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * A service interface to fetch blood donation-related data from a network source.
 */
interface BloodDonationService {

    /**
     * Fetches a list of [DonationCenter] from the network source.
     *
     * This is a suspend function and should be called from a coroutine context.
     *
     * @return A list of [DonationCenter].
     */
    suspend fun getDonationCenters(): List<DonationCenter>

    /**
     * Factory for building an instance of [BloodDonationService].
     *
     * Isolates the service creation logic from the other architectural layers, adhering to the Dependency Inversion Principle.
     */
    companion object Factory {
        /**
         * Builds a [BloodDonationService] instance with a configured HTTP client.
         *
         * The client is configured to ignore unknown keys in JSON responses to prevent runtime errors due to changes in the API response structure.
         *
         * @return An instance of [BloodDonationService].
         */
        fun build(): BloodDonationService {
            return BloodDonationServiceImpl(
                httpClient = HttpClient(Android) {
                    install(ContentNegotiation) {
                        json(
                            Json {
                                // If the server sends extra fields, ignore them
                                ignoreUnknownKeys = true
                            }
                        )
                    }
                }
            )
        }
    }
}
