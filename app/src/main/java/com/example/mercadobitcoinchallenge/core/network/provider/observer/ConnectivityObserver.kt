package com.example.mercadobitcoinchallenge.core.network.provider.observer

import kotlinx.coroutines.flow.Flow

internal interface ConnectivityObserver {

    enum class Status {
        Available, Unavailable, Losing, Lost
    }

    fun observe(): Flow<Status>
}
