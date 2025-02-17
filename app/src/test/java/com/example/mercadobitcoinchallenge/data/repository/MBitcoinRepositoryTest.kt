package com.example.mercadobitcoinchallenge.data.repository

import com.example.mercadobitcoinchallenge.commons.coVerifyOnce
import com.example.mercadobitcoinchallenge.data.datasource.MBitcoinRemoteDataSource
import com.example.mercadobitcoinchallenge.data.mapper.toDomain
import com.example.mercadobitcoinchallenge.domain.repository.MBitcoinRepository
import com.example.mercadobitcoinchallenge.mocks.exchangeResponseMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MBitcoinRepositoryTest {

    private val remoteDataSource: MBitcoinRemoteDataSource = mockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    private lateinit var repository: MBitcoinRepository

    @Before
    fun setUp() {
        repository = MBitcoinRepositoryImpl(remoteDataSource, testDispatcher)
    }

    @Test
    fun `GIVEN successful flow WHEN getExchangeList is called THEN should return response as model`() {
        runTest {
            // Given
            val exchangesMock = listOf(
                exchangeResponseMock,
                exchangeResponseMock,
                exchangeResponseMock
            )
            val flowMock = flowOf(exchangesMock)

            coEvery { remoteDataSource.getExchangeList() } returns flowMock

            // When
            val result = repository.getExchangeList()

            // Then
            result.collect { response ->
                assertEquals(exchangesMock.map { it.toDomain() }, response)
            }

            coVerifyOnce {
                remoteDataSource.getExchangeList()
            }
        }
    }

    @Test
    fun `GIVEN failure flow WHEN getExchangeList is called THEN should return exception`() {
        runTest {
            // Given
            val expectedException = RuntimeException("Error")
            coEvery { remoteDataSource.getExchangeList() } returns flow { throw expectedException }

            // When
            val result = repository.getExchangeList()

            // Then
            result.catch { actual ->
                assertEquals(expectedException.message, actual.message)
            }.collect()

            coVerifyOnce {
                remoteDataSource.getExchangeList()
            }
        }
    }
}