package com.arkvis.learning

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dot {

    @Composable
    fun Dot(color: Color, dotSize: Dp, paddingTop: Dp = 0.dp) {
        Canvas(
            modifier = Modifier
                .padding(top = paddingTop)
                .size(dotSize)
        ) {
            drawCircle(
                color = color,
                radius = size.minDimension / 2,
                center = center
            )
        }
    }
}