package com.example.mercadobitcoinchallenge.core.network.exceptions

class NotFoundException(
    message: String,
    cause: Throwable,
    val code: Int,
    val body: String? = null
): MappedHttpErrorException(message)
