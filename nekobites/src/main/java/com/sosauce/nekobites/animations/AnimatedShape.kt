package com.sosauce.nekobites.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.graphics.shapes.Morph
import androidx.graphics.shapes.RoundedPolygon


/**
 * Creates a [MorphPolygonShape] to easily animate between 2 shapes
 */
@Composable
fun rememberAnimatedShape(
    condition: Boolean,
    shapeA: RoundedPolygon,
    shapeB: RoundedPolygon
): MorphPolygonShape {

    val morph = remember(shapeA, shapeB) {
        Morph(
            shapeA,
            shapeB
        )
    }
    val animatedProgress by animateFloatAsState(
        targetValue = if (condition) 1f else 0f,
        animationSpec = bouncySpec()
    )
    return remember(morph, animatedProgress) {
        MorphPolygonShape(morph, animatedProgress)
    }
}