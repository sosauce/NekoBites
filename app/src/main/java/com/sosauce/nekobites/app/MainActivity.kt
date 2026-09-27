package com.sosauce.nekobites.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.sosauce.nekobites.animations.AnimatedFab
import com.sosauce.nekobites.R as NekoBitesR
import com.sosauce.nekobites.app.ui.theme.NekoBitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NekoBitesTheme {
                Box(
                    Modifier.fillMaxSize(),
                    Alignment.Center
                ) {
                    AnimatedFab(
                        onClick = {},
                        icon = NekoBitesR.drawable.close
                    )
                }
            }
        }
    }
}

