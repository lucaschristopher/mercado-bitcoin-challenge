package com.example.mercadobitcoinchallenge.presentation.navigation.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

private const val APP_STATE_ERROR_MESSAGE = "Composition Error"

internal val localAppStateComposition =
    compositionLocalOf<MBitcoinAppState> { error(APP_STATE_ERROR_MESSAGE) }

class MBitcoinAppState(
    val navController: NavHostController
) {
    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}

@Composable
internal fun rememberAppState(
    navController: NavHostController = rememberNavController()
): MBitcoinAppState {

    return remember(navController) {
        MBitcoinAppState(
            navController
        )
    }
}
