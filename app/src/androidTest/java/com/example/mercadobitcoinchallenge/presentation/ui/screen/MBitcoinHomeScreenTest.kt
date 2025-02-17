package com.example.mercadobitcoinchallenge.presentation.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mercadobitcoinchallenge.mocks.exchangeModelMock
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinState
import com.example.mercadobitcoinchallenge.presentation.ui.screens.home.MBitcoinHomeContent
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MBitcoinHomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCheckIfAllItemsAreDisplayed() {
        val uiState = MBitcoinState(
            exchanges = listOf(
                exchangeModelMock.copy(name = "BINANCE", exchangeId = "BINANCE"),
                exchangeModelMock.copy(name = "KRAKEN", exchangeId = "KRAKEN"),
                exchangeModelMock.copy(name = "COINBASE", exchangeId = "COINBASE"),
                exchangeModelMock.copy(name = "BITSTAMP", exchangeId = "BITSTAMP"),
                exchangeModelMock.copy(name = "GEMINI", exchangeId = "GEMINI"),
                exchangeModelMock.copy(name = "ECB", exchangeId = "ECB")
            )
        )

        composeTestRule.setContent {
            MBitcoinHomeContent(uiState = uiState) {}
        }

        uiState.exchanges.forEach { item ->
            composeTestRule.onNodeWithTag(item.exchangeId).assertIsDisplayed()
        }
    }

    @Test
    fun testScrollToASpecificItemAndCheckIfItsDisplayed() {
        val uiState = MBitcoinState(
            exchanges = listOf(
                exchangeModelMock.copy(name = "BINANCE", exchangeId = "BINANCE"),
                exchangeModelMock.copy(name = "KRAKEN", exchangeId = "KRAKEN"),
                exchangeModelMock.copy(name = "COINBASE", exchangeId = "COINBASE"),
                exchangeModelMock.copy(name = "BITSTAMP", exchangeId = "BITSTAMP"),
                exchangeModelMock.copy(name = "GEMINI", exchangeId = "GEMINI"),
                exchangeModelMock.copy(name = "ECB", exchangeId = "ECB")
            )
        )

        composeTestRule.setContent {
            MBitcoinHomeContent(uiState = uiState) {}
        }

        composeTestRule.onNodeWithTag("GEMINI").performScrollTo()
        composeTestRule.onNodeWithTag("GEMINI").assertIsDisplayed()
    }

    @Test
    fun testClickOnAnItemAndVerifyTheAction() {
        val uiState = MBitcoinState(
            exchanges = listOf(
                exchangeModelMock.copy(name = "BINANCE", exchangeId = "BINANCE"),
                exchangeModelMock.copy(name = "KRAKEN", exchangeId = "KRAKEN"),
                exchangeModelMock.copy(name = "COINBASE", exchangeId = "COINBASE"),
                exchangeModelMock.copy(name = "BITSTAMP", exchangeId = "BITSTAMP"),
                exchangeModelMock.copy(name = "GEMINI", exchangeId = "GEMINI"),
                exchangeModelMock.copy(name = "ECB", exchangeId = "ECB")
            )
        )

        composeTestRule.setContent {
            MBitcoinHomeContent(uiState = uiState) {}
        }

        composeTestRule.onNodeWithTag("GEMINI")
            .assertIsDisplayed()
            .performClick()
    }
}