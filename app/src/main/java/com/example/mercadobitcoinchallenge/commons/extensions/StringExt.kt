package com.example.mercadobitcoinchallenge.commons.extensions

import com.example.mercadobitcoinchallenge.core.network.data.CustomErrorResponse
import com.google.gson.Gson

const val SPACE_STRING = " "
const val DEFAULT_STRING = "-"

fun String.toCustomResponseError(): CustomErrorResponse {
    return try {
        Gson().fromJson(this, CustomErrorResponse::class.java)
    } catch (ex: Exception) {
        CustomErrorResponse(
            error = ex.toString(),
            attempts = 0
        )
    }
}
