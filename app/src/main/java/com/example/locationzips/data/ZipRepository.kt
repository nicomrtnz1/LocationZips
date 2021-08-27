package com.example.zipcodes.data

import android.util.Log
import com.example.locationzips.WEB_SERVICE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ZipRepository {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(WEB_SERVICE_URL)
            .build()
    }

    private val zipCodeApi: ZipCodeApiService by lazy {
        retrofit.create(ZipCodeApiService::class.java)
    }

    suspend fun getZips(city:String, state:String): List<String>? {
        val response = zipCodeApi.getCityZips(city,state)
        Log.d("asdf",response.body()?.zip_codes.toString())
        return if (response.isSuccessful)
            response.body()?.zip_codes ?: emptyList()
        else
           emptyList()
    }
}