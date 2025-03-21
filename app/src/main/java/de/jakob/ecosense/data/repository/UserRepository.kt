package de.jakob.ecosense.data.repository

import de.jakob.ecosense.data.api.UserService
import de.jakob.ecosense.data.model.UserDto

class UserRepository(private val userService: UserService) {

    suspend fun getUserInfo(sessionToken: String): UserDto {
        return userService.getUserInfo(sessionToken)
    }
}
