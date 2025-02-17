package com.example.mercadobitcoinchallenge.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import com.example.mercadobitcoinchallenge.presentation.navigation.routes.Routes
import com.example.mercadobitcoinchallenge.presentation.navigation.state.MBitcoinAppState
import com.example.mercadobitcoinchallenge.presentation.navigation.state.localAppStateComposition
import com.example.mercadobitcoinchallenge.presentation.navigation.wrapper.detailsNavigation
import com.example.mercadobitcoinchallenge.presentation.navigation.wrapper.homeNavigation

@Composable
internal fun NavigationGraph(
    modifier: Modifier = Modifier,
    appState: MBitcoinAppState,
    startDestination: String = Routes.Home.route
) {
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)

    CompositionLocalProvider(localAppStateComposition provides appState) {
        NavHost(
            modifier = modifier,
            navController = appState.navController,
            startDestination = startDestination
        ) {
            homeNavigation(viewModelStoreOwner, appState::navigate)
            detailsNavigation(appState::popBackStack)
        }
    }
}