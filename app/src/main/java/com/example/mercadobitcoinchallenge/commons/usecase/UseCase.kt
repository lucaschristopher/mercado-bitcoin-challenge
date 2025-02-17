package com.example.mercadobitcoinchallenge.commons.usecase

import com.example.mercadobitcoinchallenge.commons.flow.FlowResult
import kotlinx.coroutines.flow.Flow

interface UseCase<Data, Error> : () -> Flow<FlowResult<Data, Error>>
