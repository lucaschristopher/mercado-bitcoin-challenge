package com.example.mercadobitcoinchallenge.commons

import io.mockk.MockKStubScope
import io.mockk.MockKVerificationScope
import io.mockk.coVerify
import io.mockk.verify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

fun verifyOnce(verifyBlock: MockKVerificationScope.() -> Unit) {
    verify(exactly = 1, verifyBlock = verifyBlock)
}

fun coVerifyOnce(verifyBlock: suspend MockKVerificationScope.() -> Unit) {
    coVerify(exactly = 1, verifyBlock = verifyBlock)
}

fun coVerifyNever(verifyBlock: suspend MockKVerificationScope.() -> Unit) {
    coVerify(exactly = 0, verifyBlock = verifyBlock)
}

fun verifyNever(verifyBlock: MockKVerificationScope.() -> Unit) {
    verify(exactly = 0, verifyBlock = verifyBlock)
}

infix fun <T, B> MockKStubScope<Flow<T>, B>.emits(returnValue: T) = returns(flowOf(returnValue))
