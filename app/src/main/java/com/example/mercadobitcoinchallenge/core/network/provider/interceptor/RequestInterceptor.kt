package com.example.mercadobitcoinchallenge.core.network.provider.interceptor

import com.example.mercadobitcoinchallenge.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

private const val AUTHORIZATION = "Authorization"

internal class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            addHeader(AUTHORIZATION, "Bearer ${BuildConfig.API_KEY}")
        }
        return chain.proceed(builder.build())
    }
}
