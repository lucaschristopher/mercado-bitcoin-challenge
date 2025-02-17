package com.example.mercadobitcoinchallenge.commons.mvi

import com.example.mercadobitcoinchallenge.core.network.data.CustomErrorResponse

sealed class GenericExceptionResult {

    data class OnGenericError(val onRetryButtonClick: (() -> Unit)? = null) :
        GenericExceptionResult()

    data class OnGenericErrorExceeded(val customErrorResponse: CustomErrorResponse) :
        GenericExceptionResult()

    data class OnNoNetworkError(val onRetryButtonClick: (() -> Unit)? = null) :
        GenericExceptionResult()

    data object OnNoNetworkErrorExceeded : GenericExceptionResult()
}
