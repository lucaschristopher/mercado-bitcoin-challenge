package com.example.mercadobitcoinchallenge.presentation.mvi

import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel

internal sealed interface MBitcoinAction {
    data object GetExchangeList : MBitcoinAction
    data class OnItemClick(val model: ExchangeModel) : MBitcoinAction
}
