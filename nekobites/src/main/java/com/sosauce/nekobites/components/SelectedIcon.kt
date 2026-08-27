@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.sosauce.nekobites.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sosauce.nekobites.R
import com.sosauce.nekobites.animations.unclippedContentTransform

@Composable
fun AnimatedSelectedIcon(
    isSelected: Boolean,
    unselectedContent: @Composable (AnimatedContentScope.() -> Unit)
) {
    AnimatedContent(
        targetState = isSelected,
        transitionSpec = { unclippedContentTransform() },
        modifier = Modifier.padding(start = 10.dp)
    ) {
        if (it) {
            SelectedItemLogo()
        } else {
            unselectedContent()
        }
    }
}

@Composable
private fun SelectedItemLogo() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(MaterialShapes.Cookie9Sided.toShape())
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.check),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}
