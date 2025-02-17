package com.example.mercadobitcoinchallenge.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mercadobitcoinchallenge.commons.extensions.onError
import com.example.mercadobitcoinchallenge.commons.extensions.onSuccess
import com.example.mercadobitcoinchallenge.commons.viewmodel.BaseViewModel
import com.example.mercadobitcoinchallenge.domain.model.ExchangeModel
import com.example.mercadobitcoinchallenge.domain.usecase.GetExchangeListUseCase
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinResult
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
internal class MBitcoinViewModel @Inject constructor(
    private val useCase: GetExchangeListUseCase
) : BaseViewModel<MBitcoinAction, MBitcoinResult, MBitcoinState>() {

    override val initialState: MBitcoinState
        get() = MBitcoinState()

    override fun dispatch(actionEvent: MBitcoinAction) {
        when (actionEvent) {
            is MBitcoinAction.GetExchangeList -> getExchangeList()
            is MBitcoinAction.OnItemClick -> goToDetails(actionEvent.model)
        }
    }

    private fun getExchangeList() {
        useCase()
            .onStart { updateUiState { copy(isLoading = true) } }
            .onCompletion { updateUiState { copy(isLoading = false) } }
            .onSuccess { exchanges ->
                updateUiState(uiState.value.copy(exchanges = exchanges))
            }
            .onError {
                updateUiState(uiState.value.copy(exception = it as? Exception))
            }
            .launchIn(viewModelScope)
    }

    private fun goToDetails(model: ExchangeModel) {
        emitScreenResult(MBitcoinResult.GoToDetails(model))
    }
}