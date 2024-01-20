package com.ironmanyg.profile_datasource.network

import com.ironmanyg.profile_datasource.network.model.UserDto
import com.ironmanyg.profile_datasource.network.model.UserDtoPartial
import com.ironmanyg.profile_domain.user.User
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Service interface to handle operations related to user profiles.
 * This interface abstracts the CRUD operations for user profiles in a remote data source.
 */
interface ProfileService {

    /**
     * Retrieves the profile of a user with the specified ID.
     *
     * @param userID The ID of the user whose profile needs to be retrieved.
     * @return The [User] profile.
     */
    suspend fun getProfile(userID: String): User

    /**
     * Creates a new user profile using the details provided in the [UserDto] parameter.
     *
     * @param user A data transfer object representing the user to be created.
     * @return The created [User] profile.
     */
    suspend fun createProfile(user: UserDto): User

    /**
     * Updates an existing user's profile with full details.
     *
     * @param userID The ID of the user whose profile needs to be updated.
     * @param user A data transfer object representing the updated user profile.
     * @return The updated [User] profile.
     */
    suspend fun updateProfile(userID: String, user: UserDto): User

    /**
     * Partially updates an existing user's profile.
     * This method allows for updating only specific fields of a user's profile.
     *
     * @param userID The ID of the user whose profile needs to be updated.
     * @param partialUser A data transfer object representing the partially updated user profile.
     * @return The updated [User] profile.
     */
    suspend fun updateProfilePartial(userID: String, partialUser: UserDtoPartial): User

    /**
     * Deletes the profile of a user with the specified ID.
     *
     * @param userID The ID of the user whose profile needs to be deleted.
     * @return True if the profile was deleted successfully, false otherwise.
     */
    suspend fun deleteProfile(userID: String) : Boolean

    /**
     * A companion object which serves as a factory for creating instances of [ProfileService].
     */
    companion object Factory {
        /**
         * Builds a new instance of [ProfileService] with a pre-configured HTTP client.
         *
         * @return A new instance of [ProfileService].
         */
        fun build(): ProfileService {
            return ProfileServiceImpl(
                httpClient = HttpClient(Android) {
                    install(ContentNegotiation) {
                        json(
                            Json {
                                ignoreUnknownKeys = true
                            }
                        )
                    }
                }
            )
        }
    }
}
