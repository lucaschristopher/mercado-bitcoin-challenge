package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercadobitcoinchallenge.R
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinState
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Brand01
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Typography
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp16
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp24
import com.example.mercadobitcoinchallenge.presentation.ui.theme.ibmSansSerifFamily

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
        item {
            Text(
                text = stringResource(id = R.string.mb_screen_title),
                color = Brand01,
                style = Typography.titleLarge.copy(
                    fontFamily = ibmSansSerifFamily,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.size(dp24))
        }

        items(uiState.exchanges) { item ->
            MBitcoinListItemComponent(
                item = item,
                onUiEvent = onUiEvent
            )
        }
    }

    MBitcoinHomeSkeleton(uiState.isLoading)
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