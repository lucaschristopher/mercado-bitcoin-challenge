package com.example.mercadobitcoinchallenge.commons.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadobitcoinchallenge.commons.extensions.handle
import com.example.mercadobitcoinchallenge.commons.mvi.GenericExceptionResult
import com.example.mercadobitcoinchallenge.core.analytics.Analytics
import com.example.mercadobitcoinchallenge.core.network.data.CustomErrorResponse
import com.example.mercadobitcoinchallenge.core.network.exceptions.IgnoreException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<ACTION, RESULT, STATE>(private val analytics: Analytics? = null) :
    ViewModel() {
    private val _screen = MutableSharedFlow<RESULT>()
    val screen: SharedFlow<RESULT> = _screen

    private val _genericScreen = MutableSharedFlow<GenericExceptionResult>()
    val genericExceptionsFlow: SharedFlow<GenericExceptionResult> = _genericScreen

    private val _uiState: MutableStateFlow<STATE> by lazy { MutableStateFlow(initialState) }
    val uiState: StateFlow<STATE> = _uiState

    abstract val initialState: STATE

    val currentState: STATE get() = uiState.value

    private val attemptsRetryNoNetworkException = mutableIntStateOf(ZERO)
    private val attemptsRetryGenericException = mutableIntStateOf(ZERO)

    abstract fun dispatch(actionEvent: ACTION)

    protected fun emitScreenResult(screenResult: RESULT) = viewModelScope.launch {
        _screen.emit(screenResult)
    }

    private fun emitGenericExceptionResult(genericExceptionResult: GenericExceptionResult) =
        viewModelScope.launch {
            _genericScreen.emit(genericExceptionResult)
        }

    protected fun updateUiState(uiState: STATE) {
        _uiState.value = uiState
    }

    protected fun updateUiState(reduce: STATE.() -> STATE) {
        _uiState.value = uiState.value.reduce()
    }

    protected fun handleGenericExceptions(
        exception: Exception,
        onRetry: () -> Unit
    ) {
        if (exception is IgnoreException) return

        exception.handle(
            onNoNetworkException = {
                handleNoNetworkException(onRetry = onRetry)
            },
            onNoNetworkExceptionExceeded = {
                handleNoNetworkExceededException()
            },
            onGenericError = {
                handleGenericException(it ?: CustomErrorResponse(), onRetry)
            },
            onGenericErrorExceeded = {
                handleGenericExceededException(it ?: CustomErrorResponse())
            },
            attemptsRetryNoNetworkException = attemptsRetryNoNetworkException,
            attemptsRetryGenericException = attemptsRetryGenericException
        )
    }

    private fun handleGenericException(
        customErrorResponse: CustomErrorResponse,
        onRetry: () -> Unit
    ) {
        analytics?.run { trackGenericError(customErrorResponse) }

        emitGenericExceptionResult(
            GenericExceptionResult.OnGenericError {
                onRetry()
            }
        )
    }

    private fun handleNoNetworkException(onRetry: () -> Unit) {
        analytics?.run { trackNoNetworkError() }

        emitGenericExceptionResult(
            GenericExceptionResult.OnNoNetworkError {
                onRetry()
            }
        )
    }

    private fun handleGenericExceededException(it: CustomErrorResponse) {
        emitGenericExceptionResult(
            GenericExceptionResult.OnGenericErrorExceeded(it)
        )
    }

    private fun handleNoNetworkExceededException() {
        emitGenericExceptionResult(GenericExceptionResult.OnNoNetworkErrorExceeded)
    }

    companion object {
        private const val ZERO = 0
    }
}
