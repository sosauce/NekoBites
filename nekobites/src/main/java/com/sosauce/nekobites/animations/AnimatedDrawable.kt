package com.sosauce.nekobites.animations

import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sosauce.nekobites.R

@Composable
fun AnimatedDrawable(
    modifier: Modifier = Modifier,
    drawable: AnimatedDrawableFile,
    atEnd: Boolean
) {


    val resource = when (drawable) {
        AnimatedDrawableFile.MORE_VERT -> R.drawable.animated_morevert
        AnimatedDrawableFile.SORT -> R.drawable.animated_sort
        AnimatedDrawableFile.PLAY -> R.drawable.animated_play
    }


    val animated = rememberAnimatedVectorPainter(
        animatedImageVector = AnimatedImageVector.animatedVectorResource(resource),
        atEnd = atEnd
    )

    Icon(
        painter = animated,
        contentDescription = null,
        modifier = modifier.size(24.dp)
    )
}