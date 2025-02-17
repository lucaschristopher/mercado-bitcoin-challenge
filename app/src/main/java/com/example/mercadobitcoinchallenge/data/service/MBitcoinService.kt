package com.example.mercadobitcoinchallenge.data.service

import com.example.mercadobitcoinchallenge.data.model.ExchangeResponse
import retrofit2.http.GET

internal interface MBitcoinService {

    @GET("$V1$EXCHANGES")
    suspend fun getExchangeList(): List<ExchangeResponse>

    private companion object {
        const val V1 = "/v1"
        const val EXCHANGES = "/exchanges"
    }
}
