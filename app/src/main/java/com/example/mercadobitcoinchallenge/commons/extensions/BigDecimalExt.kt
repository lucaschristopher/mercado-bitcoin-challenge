package com.example.mercadobitcoinchallenge.commons.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

private const val NBSP_TAG = "\u00A0"
private const val EMPTY_TAG = " "

fun BigDecimal.toDollar() =
    NumberFormat.getCurrencyInstance(Locale.US).format(this).replace(NBSP_TAG, EMPTY_TAG)
