package com.example.mercadobitcoinchallenge.core.network.exceptions

class NoNetworkException(
    cause: Throwable? = null
) : MappedHttpErrorException(cause)
