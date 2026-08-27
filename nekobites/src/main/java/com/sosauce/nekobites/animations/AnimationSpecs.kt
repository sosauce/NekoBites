package com.sosauce.nekobites.animations

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

fun <T> bouncySpec() = spring<T>(
    dampingRatio = Spring.DampingRatioMediumBouncy,
    stiffness = Spring.StiffnessLow
)

/**
 * Allows the bouncy spec to not get clipped
 */
fun unclippedContentTransform(): ContentTransform {
    return ContentTransform(
        targetContentEnter = scaleIn(bouncySpec()),
        initialContentExit = scaleOut(bouncySpec()),
        sizeTransform = SizeTransform(clip = false)
    )
}