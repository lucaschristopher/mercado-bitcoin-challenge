package com.example.mercadobitcoinchallenge.core.network.exceptions

/**
 * Should be thrown when occurs a 5xx Http error
 */
class HttpServerErrorException(
    message: String,
    cause: Throwable,
    val code: Int,
    val body: String? = null
) : MappedHttpErrorException(message, cause)
