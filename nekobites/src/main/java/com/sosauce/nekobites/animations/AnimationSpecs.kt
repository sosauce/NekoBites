package com.sosauce.nekobites.animations

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring

fun <T> bouncySpec() = spring<T>(
    dampingRatio = Spring.DampingRatioMediumBouncy,
    stiffness = Spring.StiffnessLow
)
