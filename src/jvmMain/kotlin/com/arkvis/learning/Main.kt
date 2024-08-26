package com.arkvis.learning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkvis.learning.content.Content
import com.arkvis.learning.options.Options
import com.arkvis.learning.sidebar.SideBar

@Composable
fun App() {
    MaterialTheme {
        MainLayout()
    }
}

@Composable
fun MainLayout() {
    Row(Modifier.background(color = AppColors.BACKGROUND)) {
        SideBar().Layout(Modifier.weight(1.5f))
        Content().Layout(Modifier.weight(5f))
        Options().Layout(Modifier.weight(2f))
    }
}

fun main() = application {
    val windowState = rememberWindowState(
        placement = WindowPlacement.Maximized
    )

    Window(onCloseRequest = ::exitApplication, state = windowState) {
        App()
    }
}
