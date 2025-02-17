package com.example.mercadobitcoinchallenge.core.analytics

import com.example.mercadobitcoinchallenge.core.network.data.CustomErrorResponse

interface Analytics {

    fun trackScreen(name: String)
    fun trackScreen(name: String, error: String, errorDescription: String)
    fun trackNoNetworkError()
    fun trackGenericError(customErrorResponse: CustomErrorResponse)
}
