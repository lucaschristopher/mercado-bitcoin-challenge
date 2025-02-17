package com.example.mercadobitcoinchallenge.presentation.ui.screens.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercadobitcoinchallenge.R
import com.example.mercadobitcoinchallenge.commons.extensions.toDollar
import com.example.mercadobitcoinchallenge.commons.utils.DateUtils
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.presentation.ui.components.CustomTextComponent
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLight01
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLight02
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Typography
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp10
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp16
import com.example.mercadobitcoinchallenge.presentation.ui.theme.ibmSansSerifFamily

@Composable
internal fun MBitcoinExchangeDetailsScreen(
    modifier: Modifier = Modifier,
    model: ExchangeModel,
    popBackStack: () -> Unit
) {

    BackHandler {
        popBackStack()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NeutralLight02)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier.padding(vertical = dp10),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.mb_back_button_content_description)
                )
            }
            Text(
                modifier = Modifier,
                text = stringResource(R.string.mb_details_label),
                style = Typography.titleLarge.copy(
                    fontFamily = ibmSansSerifFamily,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(NeutralLight01)
        ) {
            Column(
                modifier = Modifier.padding(dp16),
                verticalArrangement = Arrangement.spacedBy(dp16)
            ) {
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_id_label),
                    secondString = model.exchangeId
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_name_label),
                    secondString = model.name
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_website_label),
                    secondString = model.website
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_order_book_start_data_label),
                    secondString = DateUtils.formatDateBr(
                        locale = DateUtils.localeBr,
                        date = model.dataOrderBookStart
                    )
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_order_book_end_data_label),
                    secondString = DateUtils.formatDateBr(
                        locale = DateUtils.localeBr,
                        date = model.dataOrderBookEnd
                    )
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_volume_1_hour_usd_label),
                    secondString = model.volume1hrsUSD.toBigDecimal().toDollar()
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_volume_1_day_usd_label),
                    secondString = model.volume1dayUSD.toBigDecimal().toDollar()
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_volume_1_month_usd_label),
                    secondString = model.volume1mthUSD.toBigDecimal().toDollar()
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_rank_label),
                    secondString = model.rank.toString()
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_data_trade_start_label),
                    secondString = DateUtils.formatDateBr(
                        locale = DateUtils.localeBr,
                        date = model.dataTradeStart
                    )
                )
                CustomTextComponent(
                    firstString = stringResource(R.string.mb_data_trade_end_label),
                    secondString = DateUtils.formatDateBr(
                        locale = DateUtils.localeBr,
                        date = model.dataTradeEnd
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun MBitcoinExchangeDetailsScreenPreview() {
    MBitcoinExchangeDetailsScreen(
        model = ExchangeModel(
            exchangeId = "BINANCE",
            name = "Binance",
            volume1hrsUSD = 246891753.57,
            volume1dayUSD = 2842960235.67,
            volume1mthUSD = 585837073311.87,
            dataQuoteStart = "2017-12-18T00:00:00.0000000Z",
            dataQuoteEnd = "2025-02-05T00:00:00.0000000Z",
            rank = 2
        ),
        popBackStack = {}
    )
}