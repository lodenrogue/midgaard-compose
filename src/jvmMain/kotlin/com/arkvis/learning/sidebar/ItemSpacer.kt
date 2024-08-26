package com.arkvis.learning.sidebar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ItemSpacer {

    @Composable
    fun ItemSpacer() {
        Spacer(modifier = Modifier.width(16.dp))
    }
}