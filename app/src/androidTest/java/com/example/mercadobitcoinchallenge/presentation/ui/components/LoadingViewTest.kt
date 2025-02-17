package com.example.mercadobitcoinchallenge.presentation.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.mercadobitcoinchallenge.presentation.ui.screens.home.MBitcoinHomeSkeleton
import org.junit.Rule
import org.junit.Test

class LoadingViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkShowSkeleton() {
        composeTestRule.setContent {
            MBitcoinHomeSkeleton()
        }

        composeTestRule.onNodeWithTag("skeleton")
            .assertIsDisplayed()
    }
}