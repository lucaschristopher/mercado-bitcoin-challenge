package com.example.mercadobitcoinchallenge.presentation.viewmodel

import com.example.mercadobitcoinchallenge.commons.MainDispatcherRule
import com.example.mercadobitcoinchallenge.commons.flow.FlowResult
import com.example.mercadobitcoinchallenge.commons.observeEffect
import com.example.mercadobitcoinchallenge.commons.verifyOnce
import com.example.mercadobitcoinchallenge.domain.usecase.GetExchangeListUseCase
import com.example.mercadobitcoinchallenge.mocks.exchangeModelMock
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinResult
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MBitcoinViewModelTest {

    @get:Rule
    var mainDispatcherRule = MainDispatcherRule()

    private val useCase: GetExchangeListUseCase = mockk()
    private lateinit var viewModel: MBitcoinViewModel

    @Before
    fun setUp() {
        viewModel = MBitcoinViewModel(useCase)
    }

    @Test
    fun `Given viewmodel is initialized, When init is called, Then should call getExchangeListUseCase with success and updateUiState`() {
        // Given
        val expected = listOf(exchangeModelMock, exchangeModelMock, exchangeModelMock)
        every { useCase.invoke() } returns flowOf(FlowResult.Success(expected))

        // When
        viewModel.dispatch(MBitcoinAction.GetExchangeList)

        // Then
        assertContentEquals(
            expected = expected,
            actual = viewModel.uiState.value.exchanges
        )
        verifyOnce {
            useCase.invoke()
        }
    }

    @Test
    fun `Given viewmodel is initialized, When init is called, Then should call getExchangeListUseCase with error and updateUiState`() {
        // Given
        val expectedException = Exception("Ops, um erro aqui, fera!")
        every { useCase.invoke() } returns flowOf(FlowResult.Error(expectedException))

        // When
        viewModel.dispatch(MBitcoinAction.GetExchangeList)

        // Then
        assertEquals(
            expected = expectedException,
            actual = viewModel.uiState.value.exception,
        )
        verifyOnce {
            useCase.invoke()
        }
    }

    @Test
    fun `When OnItemClicked is called, Then should emit result to navigate to details screen`() {
        // Given
        val item = exchangeModelMock
        val observer = viewModel.observeEffect()

        // When
        viewModel.dispatch(MBitcoinAction.OnItemClick(item))

        // Then
        assertEquals(
            expected = MBitcoinResult.GoToDetails(item),
            actual = observer.replayCache.last(),
        )
    }
}