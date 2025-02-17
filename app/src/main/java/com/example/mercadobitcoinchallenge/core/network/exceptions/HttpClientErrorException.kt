package com.example.mercadobitcoinchallenge.core.network.exceptions

/**
 * Should be thrown when occurs a 4xx Http error
 */
class HttpClientErrorException(
    message: String,
    cause: Throwable,
    val code: Int,
    val body: String? = null
) : MappedHttpErrorException(message, cause)
