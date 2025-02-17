package com.example.mercadobitcoinchallenge.presentation.navigation.wrapper

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mercadobitcoinchallenge.commons.extensions.getRouteArgs
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.presentation.navigation.routes.Routes
import com.example.mercadobitcoinchallenge.presentation.ui.screens.details.MBitcoinExchangeDetailsScreen

internal const val EXCHANGE = "exchange"
internal fun NavGraphBuilder.detailsNavigation(
    popBackStack: () -> Unit
) {
    composable(route = "${Routes.Details.route}/{$EXCHANGE}") {
        val exchange = it.getRouteArgs(EXCHANGE, ExchangeModel::class.java)
        MBitcoinExchangeDetailsScreen(
            model = exchange,
            popBackStack = popBackStack
        )
    }
}
