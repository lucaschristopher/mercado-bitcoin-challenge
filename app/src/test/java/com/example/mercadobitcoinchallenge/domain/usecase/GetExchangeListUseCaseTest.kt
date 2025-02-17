package com.example.mercadobitcoinchallenge.domain.usecase

import com.example.mercadobitcoinchallenge.commons.coVerifyOnce
import com.example.mercadobitcoinchallenge.commons.getError
import com.example.mercadobitcoinchallenge.commons.getSuccess
import com.example.mercadobitcoinchallenge.domain.repository.MBitcoinRepository
import com.example.mercadobitcoinchallenge.mocks.exchangeModelMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetExchangeListUseCaseTest {

    private val repository: MBitcoinRepository = mockk()
    private lateinit var useCase: GetExchangeListUseCase

    @Before
    fun setUp() {
        this.useCase = GetExchangeListUseCase(repository)
    }

    @Test
    fun `Given repository returns with success When useCase is called Then should return ExamplesModel`() {
        runTest {
            // Given
            val expected = listOf(exchangeModelMock, exchangeModelMock, exchangeModelMock)
            coEvery { repository.getExchangeList() } returns flowOf(expected)

            // When
            val result = useCase.invoke()

            // Then
            assertEquals(expected = expected, actual = result.getSuccess())
            coVerifyOnce {
                repository.getExchangeList()
            }
        }
    }

    @Test
    fun `Given repository returns with failure When useCase is called Then should return Exception`() =
        runTest {
            // Given
            val expected = Exception("Ops! Ocorreu um erro ao buscar exchanges.")
            coEvery { repository.getExchangeList() } returns flow { throw expected }

            // When
            val result = useCase.invoke()

            // Then
            assertEquals(expected = expected, actual = result.getError())
            coVerifyOnce {
                repository.getExchangeList()
            }
        }
}