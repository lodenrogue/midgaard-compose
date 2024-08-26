package com.arkvis.learning.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkvis.learning.AppColors
import com.arkvis.learning.sidebar.action.ActionItem
import com.arkvis.learning.sidebar.action.Actions
import com.arkvis.learning.sidebar.chat.ChatList
import com.arkvis.learning.sidebar.profile.Profile

class SideBar {

    private val actionItem = ActionItem()

    @Composable
    fun Layout(modifier: Modifier) {
        Column(
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Logo()
            Actions().Section()
            ActionChatDivider()
            ChatList().Section()
            Spacer(Modifier.weight(1f))
            Profile().Shortcut()
        }
    }

    @Composable
    fun Logo() {
        actionItem.Item(
            rowModifier = createCommonActionModifier().padding(bottom = 16.dp),
            imagePath = "logo.png",
            actionName = "Midgaard",
            textModifier = Modifier.padding(top = 3.dp)
        )
    }

    @Composable
    fun ActionChatDivider() {
        Divider(
            color = AppColors.BORDER,
            thickness = 1.dp,
            modifier = Modifier
                .padding(8.dp)
                .padding(start = 6.dp)
                .padding(top = 16.dp, bottom = 30.dp)
        )
    }

    private fun createCommonActionModifier(): Modifier {
        return Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .padding(start = 8.dp, end = 24.dp)
    }
}
