package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercadobitcoinchallenge.R
import com.example.mercadobitcoinchallenge.commons.extensions.DEFAULT_STRING
import com.example.mercadobitcoinchallenge.commons.extensions.SPACE_STRING
import com.example.mercadobitcoinchallenge.commons.extensions.toDollar
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLightPure
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp120
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp16
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp4
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp8
import com.example.mercadobitcoinchallenge.presentation.ui.theme.ibmSansMonoFamily

@Composable
internal fun MBitcoinListItemComponent(
    modifier: Modifier = Modifier,
    item: ExchangeModel,
    onUiEvent: (MBitcoinAction) -> Unit = {}
) {
    ElevatedCard(
        modifier = Modifier
            .clickable {
                onUiEvent.invoke(MBitcoinAction.OnItemClick(item))
            }
            .padding(vertical = dp8)
            .then(modifier),
        elevation = CardDefaults.cardElevation(defaultElevation = dp4)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(NeutralLightPure)
                .padding(dp16),
            verticalArrangement = Arrangement.spacedBy(dp4)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = ibmSansMonoFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(stringResource(R.string.mb_name_label))
                    }
                    append(SPACE_STRING)
                    withStyle(
                        style = SpanStyle(
                            fontFamily = ibmSansMonoFamily,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append(item.name.ifBlank { DEFAULT_STRING })
                    }
                },
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = ibmSansMonoFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(stringResource(R.string.mb_id_label))
                    }
                    append(SPACE_STRING)
                    withStyle(
                        style = SpanStyle(
                            fontFamily = ibmSansMonoFamily,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append(item.exchangeId.ifBlank { DEFAULT_STRING })
                    }
                },
            )
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.mb_diary_usd_volume_label),
                    style = TextStyle(
                        fontFamily = ibmSansMonoFamily,
                        fontWeight = FontWeight.SemiBold
                    ),
                )
                Text(
                    text = item.volume1dayUSD.toBigDecimal().toDollar(),
                    style = TextStyle(
                        fontFamily = ibmSansMonoFamily
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun MBitcoinListItemComponentPreview() {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .height(dp120)
    ) {
        MBitcoinListItemComponent(
            item = ExchangeModel(
                exchangeId = "BINANCE",
                name = "Binance",
                website = "https://www.binance.com/",
                volume1hrsUSD = 246891753.57,
                volume1dayUSD = 2842960235.67,
                volume1mthUSD = 585837073311.87,
                rank = 2,
            )
        )
    }
}