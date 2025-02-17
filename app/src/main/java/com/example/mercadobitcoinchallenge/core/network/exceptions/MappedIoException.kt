package com.example.mercadobitcoinchallenge.core.network.exceptions

class MappedIoException(
    cause: Throwable? = null,
    val body: String? = null
) : MappedHttpErrorException(cause)
