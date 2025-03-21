package de.jakob.ecosense.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import de.jakob.ecosense.data.api.UserService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object NetworkModule {

    private const val BASE_URL = "http://localhost:8080/"

    private fun createRetrofit(): Retrofit {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // Moshi with the custom Kotlin adapter
            .build()
    }

    val userService: UserService = createRetrofit().create(UserService::class.java)
}
