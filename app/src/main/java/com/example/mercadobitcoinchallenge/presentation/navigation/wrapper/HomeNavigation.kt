package com.example.mercadobitcoinchallenge.presentation.navigation.wrapper

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mercadobitcoinchallenge.presentation.navigation.routes.Routes
import com.example.mercadobitcoinchallenge.presentation.ui.screens.home.MBitcoinHomeScreen

internal fun NavGraphBuilder.homeNavigation(
    viewModelStoreOwner: ViewModelStoreOwner,
    onNavigation: (String) -> Unit
) {
    composable(route = Routes.Home.route) {
        MBitcoinHomeScreen(
            viewModel = hiltViewModel(viewModelStoreOwner),
            onNavigation = onNavigation
        )
    }
}
