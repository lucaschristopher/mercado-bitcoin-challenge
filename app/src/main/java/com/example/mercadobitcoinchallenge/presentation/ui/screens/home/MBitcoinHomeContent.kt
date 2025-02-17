package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinState
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp16

@Composable
internal fun MBitcoinHomeContent(
    modifier: Modifier = Modifier,
    uiState: MBitcoinState,
    onUiEvent: (MBitcoinAction) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(dp16)
    ) {
        items(uiState.exchanges) { item ->
            MBitcoinListItemComponent(
                item = item,
                onUiEvent = onUiEvent
            )
        }
    }

    MBitcoinErrorComponent(
        exception = uiState.exception,
        onUiEvent = onUiEvent
    )
}

@Preview(showBackground = true)
@Composable
private fun MBitcoinHomeContentPreview() {
    MBitcoinHomeContent(
        uiState = MBitcoinState(
            isLoading = false,
            exception = null,
            exchanges = listOf(
                ExchangeModel(
                    exchangeId = "BINANCE",
                    name = "Binance",
                    volume1hrsUSD = 246891753.57,
                    rank = 2
                ),
                ExchangeModel(
                    exchangeId = "BINANCE",
                    name = "Binance",
                    volume1hrsUSD = 246891753.57,
                    rank = 2
                ),
                ExchangeModel(
                    exchangeId = "BINANCE",
                    name = "Binance",
                    volume1hrsUSD = 246891753.57,
                    rank = 2
                ),
                ExchangeModel(
                    exchangeId = "BINANCE",
                    name = "Binance",
                    volume1hrsUSD = 246891753.57,
                    rank = 2
                ),
                ExchangeModel(
                    exchangeId = "BINANCE",
                    name = "Binance",
                    volume1hrsUSD = 246891753.57,
                    rank = 2
                ), ExchangeModel(
                    exchangeId = "BINANCE",
                    name = "Binance",
                    volume1hrsUSD = 246891753.57,
                    rank = 2
                )
            )
        ),
        onUiEvent = {}
    )
}