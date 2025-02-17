package com.example.mercadobitcoinchallenge.core.network.exceptions

sealed class MappedHttpErrorException : Exception {

    constructor(message: String) : super(message)

    constructor(cause: Throwable?) : super(cause)

    constructor(message: String, cause: Throwable?) : super(message, cause)
}
