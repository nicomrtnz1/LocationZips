package com.example.zipcodes.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ZipCodeApiService {
    @GET(value = "rest/b0pzNuArMS7OebL3FLxU3pn0mVyf6ovvsnhdiiWz4b9pNFI4nIqrKzUT6BIGYpiG/city-zips.json/{city}/{state}")
    suspend fun getCityZips(
        @Path("city") city: String,
        @Path("state") state: String
    ): Response<ZipCodesResponse>
}