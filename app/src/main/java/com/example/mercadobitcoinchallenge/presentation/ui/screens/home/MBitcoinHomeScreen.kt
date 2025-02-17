package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mercadobitcoinchallenge.commons.components.LaunchOnce
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinResult
import com.example.mercadobitcoinchallenge.presentation.navigation.routes.Routes
import com.example.mercadobitcoinchallenge.presentation.viewmodel.MBitcoinViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun MBitcoinHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MBitcoinViewModel = hiltViewModel(),
    onNavigation: (String) -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface(modifier = modifier.fillMaxSize()) {
        MBitcoinHomeContent(
            modifier = modifier,
            uiState = uiState,
            onUiEvent = viewModel::dispatch
        )
    }

    LaunchedEffect(viewModel.screen) {
        viewModel.screen.collectLatest { result ->
            when (result) {
                is MBitcoinResult.GoToDetails -> onNavigation(
                    Routes.Details.createRoute(result.model)
                )
            }
        }
    }

    LaunchOnce {
        viewModel.dispatch(MBitcoinAction.GetExchangeList)
    }
}
