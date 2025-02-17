package com.example.mercadobitcoinchallenge.commons.extensions

import androidx.compose.runtime.MutableState
import com.example.mercadobitcoinchallenge.core.network.data.CustomErrorResponse
import com.example.mercadobitcoinchallenge.core.network.exceptions.ForbiddenException
import com.example.mercadobitcoinchallenge.core.network.exceptions.HttpClientErrorException
import com.example.mercadobitcoinchallenge.core.network.exceptions.HttpServerErrorException
import com.example.mercadobitcoinchallenge.core.network.exceptions.MappedIoException
import com.example.mercadobitcoinchallenge.core.network.exceptions.NoNetworkException
import com.example.mercadobitcoinchallenge.core.network.exceptions.NotFoundException
import java.lang.reflect.UndeclaredThrowableException

const val MAX_ATTEMPTS_RETRY = 3

fun Exception.handle(
    onForbiddenException: ((error: CustomErrorResponse?) -> Unit)? = null,
    onUserException: ((error: CustomErrorResponse?) -> Unit)? = null,
    onHttpClientError: ((error: CustomErrorResponse?) -> Unit)? = null,
    onNoNetworkException: () -> Unit,
    onNoNetworkExceptionExceeded: () -> Unit,
    onGenericError: (error: CustomErrorResponse?) -> Unit,
    onGenericErrorExceeded: (error: CustomErrorResponse?) -> Unit,
    attemptsRetryNoNetworkException: MutableState<Int>,
    attemptsRetryGenericException: MutableState<Int>
) {
    when (this) {
        is ForbiddenException -> {
            onForbiddenException?.let {
                onForbiddenException(this.body?.toCustomResponseError())
            } ?: run {
                handleGenericException(
                    onGenericException = { onGenericError(this.body?.toCustomResponseError()) },
                    onGenericExceededException = { onGenericErrorExceeded(this.body?.toCustomResponseError()) },
                    attemptsRetryGenericException = attemptsRetryGenericException
                )
            }
        }

        is NotFoundException -> {
            onUserException?.let {
                onUserException(this.body?.toCustomResponseError())
            } ?: run {
                handleGenericException(
                    onGenericException = { onGenericError(this.body?.toCustomResponseError()) },
                    onGenericExceededException = { onGenericErrorExceeded(this.body?.toCustomResponseError()) },
                    attemptsRetryGenericException = attemptsRetryGenericException
                )
            }
        }

        is HttpClientErrorException -> {
            onHttpClientError?.let {
                onHttpClientError(this.body?.toCustomResponseError())
            } ?: run {
                handleGenericException(
                    onGenericException = { onGenericError(this.body?.toCustomResponseError()) },
                    onGenericExceededException = { onGenericErrorExceeded(this.body?.toCustomResponseError()) },
                    attemptsRetryGenericException = attemptsRetryGenericException
                )
            }
        }

        is NoNetworkException -> {
            handleNoNetworkException(
                onNoNetworkException = { onNoNetworkException() },
                onNoNetworkExceededException = { onNoNetworkExceptionExceeded() },
                attemptsRetryNoNetworkException = attemptsRetryNoNetworkException
            )
        }

        is HttpServerErrorException -> {
            handleGenericException(
                onGenericException = { onGenericError(this.body?.toCustomResponseError()) },
                onGenericExceededException = { onGenericErrorExceeded(this.body?.toCustomResponseError()) },
                attemptsRetryGenericException = attemptsRetryGenericException
            )
        }

        is MappedIoException -> {
            handleGenericException(
                onGenericException = { onGenericError(this.body?.toCustomResponseError()) },
                onGenericExceededException = { onGenericErrorExceeded(this.body?.toCustomResponseError()) },
                attemptsRetryGenericException = attemptsRetryGenericException
            )
        }

        is UndeclaredThrowableException -> {
            when (this.undeclaredThrowable) {
                is ForbiddenException -> {
                    onForbiddenException?.let {
                        onForbiddenException(
                            (this.undeclaredThrowable as ForbiddenException).body?.toCustomResponseError()
                        )
                    } ?: run {
                        handleGenericException(
                            onGenericException = {
                                onGenericError(
                                    (this.undeclaredThrowable as ForbiddenException)
                                        .body?.toCustomResponseError()
                                )
                            },
                            onGenericExceededException = {
                                onGenericErrorExceeded(
                                    (this.undeclaredThrowable as ForbiddenException)
                                        .body?.toCustomResponseError()
                                )
                            },
                            attemptsRetryGenericException = attemptsRetryGenericException
                        )
                    }
                }

                is NotFoundException -> {
                    onUserException?.let {
                        onUserException((this.undeclaredThrowable as NotFoundException).body?.toCustomResponseError())
                    } ?: run {
                        handleGenericException(
                            onGenericException = {
                                onGenericError(
                                    (this.undeclaredThrowable as NotFoundException)
                                        .body?.toCustomResponseError()
                                )
                            },
                            onGenericExceededException = {
                                onGenericErrorExceeded(
                                    (this.undeclaredThrowable as NotFoundException)
                                        .body?.toCustomResponseError()
                                )
                            },
                            attemptsRetryGenericException = attemptsRetryGenericException
                        )
                    }
                }

                is HttpClientErrorException -> {
                    onHttpClientError?.let {
                        onHttpClientError(
                            (this.undeclaredThrowable as HttpClientErrorException)
                                .body?.toCustomResponseError()
                        )
                    } ?: run {
                        handleGenericException(
                            onGenericException = {
                                onGenericError(
                                    (this.undeclaredThrowable as HttpClientErrorException)
                                        .body?.toCustomResponseError()
                                )
                            },
                            onGenericExceededException = {
                                onGenericErrorExceeded(
                                    (this.undeclaredThrowable as HttpClientErrorException)
                                        .body?.toCustomResponseError()
                                )
                            },
                            attemptsRetryGenericException = attemptsRetryGenericException
                        )
                    }
                }

                is NoNetworkException -> {
                    handleNoNetworkException(
                        onNoNetworkException = { onNoNetworkException() },
                        onNoNetworkExceededException = { onNoNetworkExceptionExceeded() },
                        attemptsRetryNoNetworkException = attemptsRetryNoNetworkException
                    )
                }

                is HttpServerErrorException -> {
                    handleGenericException(
                        onGenericException = {
                            onGenericError(
                                (this.undeclaredThrowable as HttpServerErrorException)
                                    .body?.toCustomResponseError()
                            )
                        },
                        onGenericExceededException = {
                            onGenericErrorExceeded(
                                (this.undeclaredThrowable as HttpServerErrorException)
                                    .body?.toCustomResponseError()
                            )
                        },
                        attemptsRetryGenericException = attemptsRetryGenericException
                    )
                }

                is MappedIoException -> {
                    handleGenericException(
                        onGenericException = {
                            onGenericError(
                                (this.undeclaredThrowable as MappedIoException)
                                    .body?.toCustomResponseError()
                            )
                        },
                        onGenericExceededException = {
                            onGenericErrorExceeded(
                                (this.undeclaredThrowable as MappedIoException)
                                    .body?.toCustomResponseError()
                            )
                        },
                        attemptsRetryGenericException = attemptsRetryGenericException
                    )
                }

                else -> {
                    handleGenericException(
                        onGenericException = { onGenericError(this.message?.toCustomResponseError()) },
                        onGenericExceededException = { onGenericErrorExceeded(this.message?.toCustomResponseError()) },
                        attemptsRetryGenericException = attemptsRetryGenericException
                    )
                }
            }
        }

        else -> {
            handleGenericException(
                onGenericException = { onGenericError(this.message?.toCustomResponseError()) },
                onGenericExceededException = { onGenericErrorExceeded(this.message?.toCustomResponseError()) },
                attemptsRetryGenericException = attemptsRetryGenericException
            )
        }
    }
}

private fun handleNoNetworkException(
    onNoNetworkException: () -> Unit,
    onNoNetworkExceededException: () -> Unit,
    attemptsRetryNoNetworkException: MutableState<Int>,
) {
    attemptsRetryNoNetworkException.value++
    if (attemptsRetryNoNetworkException.value > MAX_ATTEMPTS_RETRY) {
        attemptsRetryNoNetworkException.value = 0
        onNoNetworkExceededException.invoke()
    } else {
        onNoNetworkException.invoke()
    }
}

private fun handleGenericException(
    onGenericException: () -> Unit,
    onGenericExceededException: () -> Unit,
    attemptsRetryGenericException: MutableState<Int>
) {
    attemptsRetryGenericException.value++
    if (attemptsRetryGenericException.value > MAX_ATTEMPTS_RETRY) {
        attemptsRetryGenericException.value = 0
        onGenericExceededException.invoke()
    } else {
        onGenericException.invoke()
    }
}

