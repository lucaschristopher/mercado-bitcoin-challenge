package com.example.mercadobitcoinchallenge.commons

import com.example.mercadobitcoinchallenge.commons.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

fun <T> BaseViewModel<*, *, T>.observeEffect(): SharedFlow<Any?> {
    return this.screen.shareIn(
        CoroutineScope(Dispatchers.Unconfined),
        started = SharingStarted.Eagerly,
        replay = 1
    )
}

val <T> SharedFlow<T>.lastValue: T
    get() = replayCache.last()
