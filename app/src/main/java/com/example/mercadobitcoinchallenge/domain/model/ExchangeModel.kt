package com.example.mercadobitcoinchallenge.domain.model

internal data class ExchangeModel(
    val exchangeId: String = "",
    val website: String = "",
    val name: String = "",
    val dataQuoteStart: String = "",
    val dataQuoteEnd: String = "",
    val dataOrderBookStart: String = "",
    val dataOrderBookEnd: String = "",
    val dataTradeStart: String = "",
    val dataTradeEnd: String = "",
    val volume1hrsUSD: Double = 0.0,
    val volume1dayUSD: Double = 0.0,
    val volume1mthUSD: Double = 0.0,
    val rank: Int = 0
)
