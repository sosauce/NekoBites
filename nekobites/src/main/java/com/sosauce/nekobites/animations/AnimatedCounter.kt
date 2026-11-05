package com.sosauce.nekobites.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun AnimatedCounter(
    modifier: Modifier = Modifier,
    count: Int,
    textStyle: TextStyle
) {
    var oldCount by remember { mutableIntStateOf(count) }

    LaunchedEffect(count) {
        oldCount = count
    }

    Row(modifier = modifier) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()
        for (i in countString.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]

            val char = if (oldChar == newChar) {
                oldCountString[i]
            } else countString[i]


            AnimatedContent(
                targetState = char,
                transitionSpec = {
                    if (oldCount < count) {
                        slideInVertically { it } togetherWith slideOutVertically { -it }
                    } else {
                        slideInVertically { -it } togetherWith slideOutVertically { it }
                    }
                }
            ) {
                Text(
                    text = it.toString(),
                    style = textStyle
                )
            }
        }
    }

}