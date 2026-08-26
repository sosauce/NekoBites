package com.sosauce.nekobites.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.rememberViewModelStoreOwner

/**
 * Will scope all viewmodel created inside the [content] to this Composable's lifecycle
 */
@Composable
fun ScopedViewModel(
    content: @Composable () -> Unit
) {
    val owner = rememberViewModelStoreOwner()
    CompositionLocalProvider(LocalViewModelStoreOwner provides owner) {
        content()
    }

}