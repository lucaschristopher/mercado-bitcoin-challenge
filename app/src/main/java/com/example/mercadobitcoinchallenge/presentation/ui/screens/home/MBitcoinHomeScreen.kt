package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mercadobitcoinchallenge.R
import com.example.mercadobitcoinchallenge.commons.components.LaunchOnce
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinResult
import com.example.mercadobitcoinchallenge.presentation.navigation.routes.Routes
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Brand01
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLight02
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLight03
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Typography
import com.example.mercadobitcoinchallenge.presentation.ui.theme.ibmSansSerifFamily
import com.example.mercadobitcoinchallenge.presentation.viewmodel.MBitcoinViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MBitcoinHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MBitcoinViewModel = hiltViewModel(),
    onNavigation: (String) -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface(modifier = modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = NeutralLight02,
                        titleContentColor = NeutralLight03,
                    ),
                    title = {
                        Text(
                            text = stringResource(id = R.string.mb_screen_title),
                            color = Brand01,
                            style = Typography.titleLarge.copy(
                                fontFamily = ibmSansSerifFamily,
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                    }
                )
            }
        ) { padding ->
            MBitcoinHomeContent(
                modifier = modifier.padding(padding),
                uiState = uiState,
                onUiEvent = viewModel::dispatch
            )

            MBitcoinHomeSkeleton(uiState.isLoading)
        }
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
