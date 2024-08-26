package com.arkvis.learning.sidebar.action

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.arkvis.learning.FontSizes
import com.arkvis.learning.sidebar.ItemSpacer

class ActionItem {

    private val itemSpacer = ItemSpacer()

    @Composable
    fun Item(rowModifier: Modifier, imagePath: String, actionName: String, textModifier: Modifier = Modifier) {
        Row(modifier = rowModifier) {
            Image(
                painter = painterResource(imagePath),
                contentDescription = actionName
            )

            itemSpacer.ItemSpacer()

            Text(
                text = actionName,
                style = TextStyle(
                    color = Color.White,
                    fontSize = FontSizes.DEFAULT
                ),
                modifier = textModifier
            )
        }
    }
}