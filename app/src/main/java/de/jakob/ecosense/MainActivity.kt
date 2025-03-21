package de.jakob.ecosense

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import de.jakob.ecosense.R
import de.jakob.ecosense.data.network.NetworkModule
import de.jakob.ecosense.data.repository.UserRepository
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRepository = UserRepository(NetworkModule.userService)

        fetchAndPrintUserInfo()
    }

    private fun fetchAndPrintUserInfo() {
        runBlocking {
            try {
                val sessionToken = "2ce6d19a-240e-4a40-8b20-7b9f67f49dff"
                val user = userRepository.getUserInfo(sessionToken)

                Log.d("User Info", "User ID: ${user.id}")
                Log.d("User Info", "Username: ${user.username}")
                Log.d("User Info", "Email: ${user.email}")
                Log.d("User Info", "Profile Picture URL: ${user.profilePictureUrl ?: "None"}")
                Log.d("User Info", "Bio: ${user.bio}")
                Log.d("User Info", "Created At: ${user.createdAt}")
            } catch (e: Exception) {
                Log.e("Error", "Failed to fetch user info", e)
                e.printStackTrace()
            }
        }
    }
}