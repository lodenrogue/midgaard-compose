package com.arkvis.learning.sidebar.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkvis.learning.AppColors
import com.arkvis.learning.Dot
import com.arkvis.learning.FontSizes
import com.arkvis.learning.sidebar.ItemSpacer

class ChatList {

    private val itemSpacer = ItemSpacer()

    @Composable
    fun Section() {
        ChatListTitle()
        Chats()
        AddChatButton()

    }

    @Composable
    fun Chats() {
        val chats = listOf(
            ChatData(dotColor = Color(0xFF6998d5), name = "All Chats", messageCount = "23"),
            ChatData(dotColor = Color(0xFFd9cc68), name = "Favorite", messageCount = "3"),
            ChatData(dotColor = Color(0xFFdc7a6b), name = "Archived", messageCount = "0")
        )

        chats.forEach { chat ->
            ChatItem(chat)
        }
    }

    @Composable
    fun AddChatButton() {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = AppColors.PRIMARY
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = "New Chat",
                style = TextStyle(
                    color = AppColors.PRIMARY,
                    fontSize = FontSizes.DEFAULT
                )
            )
        }
    }

    @Composable
    fun ChatItem(chat: ChatData) {
        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Dot().Dot(color = chat.dotColor, dotSize = 8.dp, paddingTop = 8.dp)
            itemSpacer.ItemSpacer()

            ChatName(chat.name)
            Spacer(modifier = Modifier.weight(1f))

            if (chat.messageCount != "0") {
                MessageCount(chat.messageCount)
            }
        }
    }

    @Composable
    fun MessageCount(count: String) {
        Box(
            modifier = Modifier
                .offset(y = (-4).dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color(0xFF2e3239))
                .size(width = 40.dp, height = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }

    @Composable
    fun ChatName(name: String) {
        Text(
            text = name,
            style = TextStyle(
                color = Color.White,
                fontSize = FontSizes.DEFAULT
            ),
        )
    }

    @Composable
    fun ChatListTitle() {
        Text(
            text = "Chat List",
            style = TextStyle(
                color = Color(0xFFb7b7b7),
                fontSize = FontSizes.DEFAULT
            ),
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )
    }
}