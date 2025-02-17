package com.example.mercadobitcoinchallenge.commons.extensions

import androidx.navigation.NavBackStackEntry
import com.google.gson.Gson

fun <T> NavBackStackEntry.getRouteArgs(key: String, out: Class<T>): T =
    Gson().fromJson(arguments?.getString(key), out)
