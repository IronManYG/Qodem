package com.ironmanyg.blood_donation_datasource.network

/**
 * An object holding the constants for the API endpoints used in the app.
 * Keeping the endpoint URLs in a single place allows for easier management and updates.
 */
object EndPoints {

    /**
     * The base URL for the API. All other endpoints will be relative to this URL.
     */
    private const val BASE_URL = "https://api.jsonbin.io/v3/b/"

    /**
     * Enumeration grouping all available API endpoints, providing better type safety and logical grouping.
     */
    enum class Endpoint(val path: String) {
        /**
         * Endpoint to fetch the donation centers information from the API.
         */
        DONATION_CENTERS("64ff620ad972192679c1e572?meta=false")
    }

    /**
     * Utility method to construct a full URL for a given endpoint.
     *
     * @param endpoint The [Endpoint] to construct the URL for.
     * @return The full URL as a [String].
     */
    fun getFullUrl(endpoint: Endpoint): String {
        return "$BASE_URL${endpoint.path}"
    }
}
