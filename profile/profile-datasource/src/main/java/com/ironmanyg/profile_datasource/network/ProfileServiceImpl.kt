package com.ironmanyg.profile_datasource.network

import com.ironmanyg.profile_datasource.network.model.UserDto
import com.ironmanyg.profile_datasource.network.model.UserDtoPartial
import com.ironmanyg.profile_datasource.network.model.toUser
import com.ironmanyg.profile_domain.user.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

/**
 * A class that implements the [ProfileService] interface. It communicates with the backend server
 * to perform CRUD operations on user profiles.
 *
 * @property httpClient The HTTP client used for network communications.
 */
class ProfileServiceImpl(
    private val httpClient: HttpClient,
) : ProfileService {

    /**
     * Retrieves the profile of a user with the specified ID by sending a GET request to the server.
     *
     * @param userID The ID of the user whose profile needs to be retrieved.
     * @return The [User] profile.
     */
    override suspend fun getProfile(userID: String): User {
        val url = EndPoints.getFullUrl(EndPoints.Endpoint.PROFILES) + userID
        val response: HttpResponse = httpClient.get(url)

        return response.body<UserDto>().toUser()
    }

    /**
     * Creates a new user profile using the details provided in the [UserDto] parameter by sending a POST request to the server.
     *
     * @param user A data transfer object representing the user to be created.
     * @return The created [User] profile.
     */
    override suspend fun createProfile(user: UserDto): User {
        val url = EndPoints.getFullUrl(EndPoints.Endpoint.PROFILES)
        val response: HttpResponse = httpClient.post(url) {
                contentType(ContentType.Application.Json)
                setBody(user)
            }

        return response.body<UserDto>().toUser()
    }

    /**
     * Updates the profile of a user with the specified ID by sending a PUT request to the server.
     *
     * @param userID The ID of the user whose profile needs to be updated.
     * @param user A data transfer object representing the updated user profile.
     * @return The updated [User] profile.
     */
    override suspend fun updateProfile(userID: String, user: UserDto): User {
        val url = EndPoints.getFullUrl(EndPoints.Endpoint.PROFILES) + userID
        val response: HttpResponse = httpClient.put(url) {
                contentType(ContentType.Application.Json)
                setBody(user)
            }

        return response.body<UserDto>().toUser()
    }

    /**
     * Updates the profile of a user with the specified ID by sending a PATCH request to the server.
     *
     * @param userID The ID of the user whose profile needs to be updated.
     * @param partialUser A data transfer object representing the updated user profile.
     * @return The updated [User] profile.
     */
    override suspend fun updateProfilePartial(userID: String, partialUser: UserDtoPartial): User {
        val url = EndPoints.getFullUrl(EndPoints.Endpoint.PROFILES) + userID
        val response: HttpResponse = httpClient.patch(url) {
                contentType(ContentType.Application.Json)
                setBody(partialUser)
            }

        return response.body<UserDto>().toUser()
    }

    /**
     * Deletes the profile of a user with the specified ID by sending a DELETE request to the server.
     *
     * @param userID The ID of the user whose profile needs to be deleted.
     * @return True if the profile was deleted successfully, false otherwise.
     */
    override suspend fun deleteProfile(userID: String): Boolean {
        val url = EndPoints.getFullUrl(EndPoints.Endpoint.PROFILES) + userID
        val response: HttpResponse = httpClient.delete(url)


        return response.status.value in 200..299
    }
}