package com.arkvis.learning.sidebar.action

import androidx.compose.ui.Modifier

data class ActionData(
    val actionName: String,
    val imagePath: String,
    val rowModifier: Modifier
)