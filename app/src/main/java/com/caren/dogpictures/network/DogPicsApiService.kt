package com.caren.dogpictures.network

import com.caren.dogpictures.fragments.breed
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// TODO Fill out the BASE_URL here




public val BASE_URL = "https://dog.ceo/api/$breed"


// Added to print out network requests and responses in Logcat
// Available via the dependency added in build.gradle: com.squareup.okhttp3:logging-interceptor:4.7.2
private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private var retrofit = Retrofit.Builder()
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(breed)
    .build()

/**
 * https://zenquotes.io/#docs
 */
interface DogPicsApiService {

    // https://dog.ceo/api/$breed/random
    @GET("random")
    suspend fun getRandomDog(): Dog



}

public fun changeApiBaseUrl(newApiBaseUrl: String): Retrofit {
    var apiBaseUrl = newApiBaseUrl
    var builder = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(apiBaseUrl)
        .build()
    return builder
}

object DogQuotesApi {
    val retrofitService: DogPicsApiService by lazy { retrofit.create(DogPicsApiService::class.java) }
    val breedRetrofit: DogPicsApiService by lazy { changeApiBaseUrl(breed).create(DogPicsApiService::class.java) }
}