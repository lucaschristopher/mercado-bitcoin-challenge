package com.example.mercadobitcoinchallenge.presentation.navigation.routes

import com.example.mercadobitcoinchallenge.commons.extensions.toJsonStringArgs
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel

const val HOME_SCREEN = "home"
const val DETAILS_SCREEN = "details"

internal sealed class Routes(val route: String) {
    data object Home : Routes(HOME_SCREEN)
    data object Details : Routes(DETAILS_SCREEN) {
        fun createRoute(model: ExchangeModel) = "$route/${model.toJsonStringArgs()}"
    }
}