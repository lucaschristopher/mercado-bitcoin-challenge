package com.example.mercadobitcoinchallenge.presentation.mvi

import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel

internal sealed interface MBitcoinResult {
    data class GoToDetails(val model: ExchangeModel) : MBitcoinResult
}