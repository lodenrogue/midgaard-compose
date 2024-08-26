package com.arkvis.learning.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkvis.learning.AppColors
import com.arkvis.learning.Dot
import com.arkvis.learning.FontSizes
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Content {

    @Composable
    fun Layout(modifier: Modifier) {
        Box(
            modifier = modifier
                .fillMaxHeight()
                .padding(vertical = 16.dp)
        ) {
            ContentCard()
        }
    }

    @Composable
    fun ContentCard() {
        val roundedCornerShape = RoundedCornerShape(24.dp)
        Card(
            backgroundColor = Color(0xFF1e1f23),
            shape = roundedCornerShape,
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = AppColors.BORDER,
                    shape = roundedCornerShape
                )
        ) {
            val hazeState = remember { HazeState() }
            Box {
                ContentBody(hazeState)
                ContentHeader(hazeState)
            }

        }
    }

    @Composable
    fun ContentHeader(hazeState: HazeState) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Color.Transparent)
                .hazeChild(hazeState)
                .fillMaxWidth()
                .drawBehind(drawBottomBorder())
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            HeaderInfo()
            HeaderActions()
        }
    }

    @Composable
    fun HeaderActions() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            PinIcon(50.dp, AppColors.CONTENT_HEADER_ICON)
            Spacer(Modifier.size(16.dp))

            FavoriteIcon(30.dp, AppColors.ACCENT)
            Spacer(Modifier.size(24.dp))

            OpenInNewWindowIcon(30.dp, AppColors.CONTENT_HEADER_ICON)
        }
    }

    @Composable
    fun OpenInNewWindowIcon(size: Dp, tint: Color) {
        Icon(
            painter = painterResource("open-in-new-icon.svg"),
            contentDescription = "Open in new window",
            tint = tint,
            modifier = Modifier.size(size)
        )
    }

    @Composable
    fun FavoriteIcon(size: Dp, tint: Color) {
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Favorite",
            tint = tint,
            modifier = Modifier.size(size)
        )
    }

    @Composable
    fun PinIcon(size: Dp, tint: Color) {
        Icon(
            painter = painterResource("keep-icon.svg"),
            contentDescription = "Pin Item",
            tint = tint,
            modifier = Modifier
                .rotate(45f)
                .size(size)
        )
    }

    @Composable
    fun HeaderInfo() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val textStyle = TextStyle(color = AppColors.TEXT, fontSize = FontSizes.SMALL)

            ContentTitle(textStyle)
            Spacer(Modifier.size(8.dp))

            Dot().Dot(color = Color.White, dotSize = 6.dp)
            Spacer(Modifier.size(8.dp))

            Date(textStyle)
        }
    }

    @Composable
    fun ContentBody(hazeState: HazeState) {
        LazyColumn(modifier = Modifier.fillMaxSize().haze(hazeState)) {
           
        }
    }

    @Composable
    fun ContentTitle(textStyle: TextStyle) {
        Text(text = "3D sphere", style = textStyle)
    }

    @Composable
    fun Date(textStyle: TextStyle) {
        val date = getCurrentDateTime()
        Text(text = date, style = textStyle)
    }

    private fun getCurrentDateTime(): String {
        val formatter = DateTimeFormatter.ofPattern("d MMM, ha z", Locale.ENGLISH)
        val now = ZonedDateTime.now(ZoneId.systemDefault())
        return now.format(formatter)
            .replace("AM", "am")
            .replace("PM", "pm")
    }

    private fun drawBottomBorder(): DrawScope.() -> Unit = {
        val strokeWidth = 1.dp.toPx()
        val y = size.height - strokeWidth / 2
        drawLine(
            color = Color.Black,
            start = Offset(0f, y),
            end = Offset(size.width, y),
            strokeWidth = strokeWidth
        )
    }
}
