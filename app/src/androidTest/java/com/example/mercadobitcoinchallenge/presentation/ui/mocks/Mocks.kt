package com.example.mercadobitcoinchallenge.mocks

import com.example.mercadobitcoinchallenge.data.model.ExchangeResponse
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel

internal val exchangeResponseMock = ExchangeResponse(
    exchangeId = "BINANCE",
    website = "https://www.binance.com/",
    name = "Binance",
    dataQuoteStart = "2017-12-18T00:00:00.0000000Z",
    dataQuoteEnd = "2025-02-05T00:00:00.0000000Z",
    dataOrderBookStart = "2017-12-18T00:00:00.0000000Z",
    dataOrderBookEnd = "2025-02-05T00:00:00.0000000Z",
    dataTradeStart = "2017-07-14T00:00:00.0000000Z",
    dataTradeEnd = "2025-02-05T00:00:00.0000000Z",
    volume1hrsUSD = 246891753.57,
    volume1dayUSD = 2842960235.67,
    volume1mthUSD = 585837073311.87,
    rank = 2
)

internal val exchangeModelMock = ExchangeModel(
    exchangeId = "BINANCE",
    website = "https://www.binance.com/",
    name = "Binance",
    dataQuoteStart = "2017-12-18T00:00:00.0000000Z",
    dataQuoteEnd = "2025-02-05T00:00:00.0000000Z",
    dataOrderBookStart = "2017-12-18T00:00:00.0000000Z",
    dataOrderBookEnd = "2025-02-05T00:00:00.0000000Z",
    dataTradeStart = "2017-07-14T00:00:00.0000000Z",
    dataTradeEnd = "2025-02-05T00:00:00.0000000Z",
    volume1hrsUSD = 246891753.57,
    volume1dayUSD = 2842960235.67,
    volume1mthUSD = 585837073311.87,
    rank = 2
)
