package com.arkvis.learning.options

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

class Options {

    @Composable
    fun Layout(modifier: Modifier) {
        Column(modifier = modifier.fillMaxHeight()) {
            Text("Options", style = TextStyle(color = Color.White))
        }
    }
}