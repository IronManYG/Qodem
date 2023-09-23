package com.ironmanyg.profile_datasource.network

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
         * Endpoint to fetch the profiles information from the API.
         */
        PROFILES("profiles/"),
        /**
         * Endpoint to fetch test profile info from API.
         */
        PROFILE("650ef93012a5d376598219a2"),
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