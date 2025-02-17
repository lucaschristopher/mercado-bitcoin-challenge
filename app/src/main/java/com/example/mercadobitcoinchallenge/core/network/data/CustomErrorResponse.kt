package com.example.mercadobitcoinchallenge.core.network.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CustomErrorResponse(
    @SerializedName("error")
    val error: Any? = null,
    @SerializedName("error_description")
    val errorDescription: Any? = null,
    @SerializedName("attempts")
    val attempts: Int? = null,
    @SerializedName("error_code")
    val errorCode: String? = null,
    @SerializedName("error_response")
    val errorResponse: Any? = null
) : Serializable
