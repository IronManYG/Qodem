package com.ironmanyg.blood_donation_datasource.network

import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.DonationCenterDto
import com.ironmanyg.blood_donation_datasource.network.model.donationCenter.toDonationCenter
import com.ironmanyg.blood_donation_domain.donationCenter.DonationCenter
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * The implementation of the [BloodDonationService] interface.
 *
 * This class contains the actual network calls using the Ktor HTTP client to fetch data from the network.
 *
 * @property httpClient The HTTP client used to make network requests.
 */
class BloodDonationServiceImpl(
    private val httpClient: HttpClient,
) : BloodDonationService {

    /**
     * Fetches a list of donation centers from the API.
     *
     * The data fetched is initially in the form of [DonationCenterDto], which is then mapped to [DonationCenter] domain model using the [toDonationCenter] extension function.
     *
     * @return A list of [DonationCenter].
     */
    override suspend fun getDonationCenters(): List<DonationCenter> {
        return httpClient.get(EndPoints.getFullUrl(EndPoints.Endpoint.DONATION_CENTERS)).body<List<DonationCenterDto>>().map {
            it.toDonationCenter()
        }
    }
}
