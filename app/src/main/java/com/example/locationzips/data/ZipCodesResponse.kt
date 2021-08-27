package com.example.zipcodes.data

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ZipCodesResponse(
    @Json(name = "zip_codes") val zip_codes: List<String>
)