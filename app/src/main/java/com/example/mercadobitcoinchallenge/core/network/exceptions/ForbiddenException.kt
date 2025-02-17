package com.example.mercadobitcoinchallenge.core.network.exceptions

import com.example.mercadobitcoinchallenge.core.network.exceptions.MappedHttpErrorException

/**
 * Should be thrown when occurs a 403 forbidden
 */
class ForbiddenException(
    message: String,
    val code: Int,
    val body: String? = null
) : MappedHttpErrorException(message)
