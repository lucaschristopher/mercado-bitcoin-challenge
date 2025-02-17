package com.example.mercadobitcoinchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadobitcoinchallenge.domain.usecase.GetExchangeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MBitcoinViewModel @Inject constructor(
    private val useCase: GetExchangeListUseCase
) : ViewModel() {

    private fun getExchangeList() {
        viewModelScope.launch {
            useCase.invoke().collect {

            }
        }
    }
}