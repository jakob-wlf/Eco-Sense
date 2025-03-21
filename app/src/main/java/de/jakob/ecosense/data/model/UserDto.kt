package de.jakob.ecosense.data.model

data class UserDto(
    val id: String,
    val username: String,
    val email: String,
    val profilePictureUrl: String?,
    val bio: String?,
    val createdAt: String
)
