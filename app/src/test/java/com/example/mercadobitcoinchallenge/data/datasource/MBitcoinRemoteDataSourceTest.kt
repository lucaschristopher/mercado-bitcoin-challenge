package com.example.mercadobitcoinchallenge.data.datasource

import com.example.mercadobitcoinchallenge.commons.BaseUnitTest
import com.example.mercadobitcoinchallenge.commons.coVerifyOnce
import com.example.mercadobitcoinchallenge.data.service.MBitcoinService
import com.example.mercadobitcoinchallenge.mocks.exchangeResponseMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

internal class MBitcoinRemoteDataSourceTest : BaseUnitTest() {
    private val service: MBitcoinService = mockk(relaxed = true)
    private lateinit var remoteDataSource: MBitcoinRemoteDataSource

    @Before
    fun setUp() {
        this.remoteDataSource = MBitcoinRemoteDataSourceImpl(service)
    }

    @Test
    fun `when getExchangeList is called then returns success`() = runTest {
        // Given
        val exchangesMock = listOf(
            exchangeResponseMock,
            exchangeResponseMock,
            exchangeResponseMock
        )

        coEvery { service.getExchangeList() } returns exchangesMock

        //When
        val result = remoteDataSource.getExchangeList()

        // Then
        result.collect { response ->
            assertNotNull(response)
            assertEquals(response, exchangesMock)
        }

        coVerifyOnce {
            service.getExchangeList()
        }
    }

    @Test
    fun `when getProducts is called then returns error`() = runTest {
        // Given
        val mockError = Exception("Vish, deu negado! =D")
        coEvery { service.getExchangeList() } throws mockError

        // When
        val result = remoteDataSource.getExchangeList()

        // Then
        result.catch {
            assertEquals(it.message, mockError.message)
        }.collect()

        coVerifyOnce {
            service.getExchangeList()
        }
    }
}
