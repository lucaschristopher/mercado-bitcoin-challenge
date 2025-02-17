package com.example.mercadobitcoinchallenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import com.example.mercadobitcoinchallenge.presentation.ui.theme.MercadoBitcoinChallengeTheme

class MBitcoinActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercadoBitcoinChallengeTheme {
            }
        }
    }
}
