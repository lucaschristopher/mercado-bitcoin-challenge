@file:JvmName(name = "ObjectExtension")

package com.example.mercadobitcoinchallenge.commons.extensions

import android.net.Uri
import com.google.gson.Gson

fun <T : Any> T.toJsonStringArgs(): String =
    Uri.encode(Gson().toJson(this))

fun <T : Any> T.toJsonString(): String =
    Gson().toJson(this)

inline fun <reified T : Any> String.toKotlinObject(): T =
    Gson().fromJson(this, T::class.java)

inline fun <reified T> T.toJson(): String = Gson().toJson(this)

inline fun <reified T, K, V> Map<K, V>.toObject(): T =
    Gson().fromJson(this.toJson(), T::class.java)

inline fun <reified T> Map<String, Any>.convert(): T = toObject()

inline fun <R> R?.orElse(block: () -> R): R {
    return this ?: block()
}
