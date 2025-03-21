package de.jakob.ecosense.data.api

import de.jakob.ecosense.data.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("eco-sense/api/users/me")
    suspend fun getUserInfo(@Header("Authorization") sessionToken: String): UserDto
}
