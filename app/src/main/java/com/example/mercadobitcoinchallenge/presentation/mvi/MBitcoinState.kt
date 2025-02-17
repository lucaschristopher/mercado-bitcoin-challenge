package com.example.mercadobitcoinchallenge.presentation.mvi

import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel

internal data class MBitcoinState(
    val isLoading: Boolean = false,
    val exception: Exception? = null,
    val exchanges: List<ExchangeModel> = emptyList()
)
