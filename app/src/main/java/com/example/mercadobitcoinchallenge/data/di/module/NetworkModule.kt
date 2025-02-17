package com.example.mercadobitcoinchallenge.data.di.module

import com.example.mercadobitcoinchallenge.BuildConfig
import com.example.mercadobitcoinchallenge.data.di.qualifier.OkHttpDefault
import com.example.mercadobitcoinchallenge.data.di.qualifier.RetrofitDefault
import com.example.mercadobitcoinchallenge.core.network.provider.factory.OkHttpClientFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    @OkHttpDefault
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClientFactory.build()

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    @RetrofitDefault
    fun providesRetrofitDefault(
        @OkHttpDefault okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}
