package com.example.mercadobitcoinchallenge.data.mapper

import com.example.mercadobitcoinchallenge.commons.extensions.orZero
import com.example.mercadobitcoinchallenge.data.model.ExchangeResponse
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel

internal fun ExchangeResponse.toDomain() = ExchangeModel(
    exchangeId = this.exchangeId.orEmpty(),
    website = this.website.orEmpty(),
    name = this.name.orEmpty(),
    dataQuoteStart = this.dataQuoteStart.orEmpty(),
    dataQuoteEnd = this.dataQuoteEnd.orEmpty(),
    dataOrderBookStart = this.dataOrderBookStart.orEmpty(),
    dataOrderBookEnd = this.dataOrderBookEnd.orEmpty(),
    dataTradeStart = this.dataTradeStart.orEmpty(),
    dataTradeEnd = this.dataTradeEnd.orEmpty(),
    volume1hrsUSD = this.volume1hrsUSD.orZero(),
    volume1dayUSD = this.volume1dayUSD.orZero(),
    volume1mthUSD = this.volume1mthUSD.orZero(),
    rank = this.rank.orZero()
)
