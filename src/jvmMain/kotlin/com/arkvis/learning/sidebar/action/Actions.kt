package com.arkvis.learning.sidebar.action

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkvis.learning.AppColors

class Actions {

    private val actionItem = ActionItem()

    @Composable
    fun Section() {
        val actions = listOf(
            ActionData("Generate", "wand.png", createGenerateActionModifier()),
            ActionData("My Images", "thumbnail.png", Modifier.padding(top = 4.dp)),
            ActionData("Explore", "compass.png", Modifier.padding(top = 2.dp)),
            ActionData("Settings", "cog.png", Modifier.padding(top = 2.dp)),
            ActionData("Support", "bubble.png", Modifier.padding(start = 5.dp, top = 1.dp))
        )

        actions.forEach { action ->
            actionItem.Item(
                rowModifier = action.rowModifier.then(createCommonActionModifier()),
                imagePath = action.imagePath,
                actionName = action.actionName
            )
        }
    }

    private fun createCommonActionModifier(): Modifier {
        return Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .padding(start = 8.dp, end = 24.dp)
    }

    private fun createGenerateActionModifier(): Modifier {
        return Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = AppColors.ACCENT)
    }
}