@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.sosauce.nekobites.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingBox(
    isLoading: Boolean,
    loadedContent: @Composable () -> Unit
) {

    AnimatedContent(
        targetState = isLoading
    ) {
        if (it) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ContainedLoadingIndicator()
            }
        } else {
            loadedContent()
        }
    }

}