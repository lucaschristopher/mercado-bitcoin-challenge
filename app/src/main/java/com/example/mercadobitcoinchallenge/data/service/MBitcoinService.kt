package com.example.mercadobitcoinchallenge.data.service

import com.example.mercadobitcoinchallenge.data.model.ExchangeResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MBitcoinService {

    @GET("$V1$EXCHANGES")
    suspend fun getExchangeList(
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) pageSize: Int
    ): List<ExchangeResponse>

    private companion object {
        const val V1 = "/v1"
        const val EXCHANGES = "exchanges"
        const val PAGE = "page"
        const val PER_PAGE = "per_page"
    }
}
