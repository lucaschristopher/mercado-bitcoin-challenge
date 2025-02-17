package com.example.mercadobitcoinchallenge.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.mercadobitcoinchallenge.R
import com.example.mercadobitcoinchallenge.core.network.provider.observer.ConnectivityObserver
import com.example.mercadobitcoinchallenge.core.network.provider.observer.NetworkConnectivityObserver
import com.example.mercadobitcoinchallenge.presentation.navigation.graph.NavigationGraph
import com.example.mercadobitcoinchallenge.presentation.navigation.state.MBitcoinAppState
import com.example.mercadobitcoinchallenge.presentation.navigation.state.rememberAppState
import com.example.mercadobitcoinchallenge.presentation.ui.theme.MercadoBitcoinChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MBitcoinActivity : ComponentActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver
    private lateinit var appState: MBitcoinAppState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initConnectivityObserver()
        setContent {
            MercadoBitcoinChallengeTheme {
                CheckConnection()

                appState = rememberAppState(navController = rememberNavController())
                NavigationGraph(appState = appState)
            }
        }
    }

    private fun initConnectivityObserver() {
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
    }

    @Composable
    private fun CheckConnection() {
        val status by connectivityObserver.observe()
            .collectAsState(initial = ConnectivityObserver.Status.Unavailable)

        if (status == ConnectivityObserver.Status.Lost) {
            Toast.makeText(
                this@MBitcoinActivity,
                getString(R.string.mb_default_error_message),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
