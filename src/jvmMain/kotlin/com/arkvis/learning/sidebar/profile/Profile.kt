package com.arkvis.learning.sidebar.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.arkvis.learning.AppColors
import com.arkvis.learning.FontSizes

class Profile {

    private val profileViewModel = ProfileViewModel()

    @Composable
    fun Shortcut() {
        Box {
            var showCard by remember { mutableStateOf(false) }

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable { showCard = !showCard }
            ) {
                ProfilePicture()
                Spacer(Modifier.width(16.dp))
                ProfileName()

                if (showCard) {
                    ProfileOptionsPopup()
                }
            }
        }
    }

    @Composable
    fun ProfileOptionsPopup() {
        Popup(
            alignment = Alignment.TopEnd,
            offset = IntOffset(x = 395, y = -600),
        ) {
            ProfileOptionsCard()
        }
    }

    @Composable
    fun ProfileOptionsCard() {
        Card(
            modifier = Modifier
                .size(
                    width = 320.dp,
                    height = 280.dp
                )
                .border(
                    width = 2.dp,
                    color = AppColors.BORDER,
                    shape = RoundedCornerShape(25.dp)
                ),
            shape = RoundedCornerShape(25.dp),
            elevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {
                Gradients()
                ProfileOptionsContent()
            }
        }
    }

    @Composable
    fun ProfileOptionsContent() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        ) {
            EditProfileOption()
            ProfileOptionsDivider()

            Option(label = "Notifications", onOptionClicked = { println("Notifications clicked") }) {
                var isChecked by remember { mutableStateOf(true) }
                ToggleSwitch(isChecked) { isChecked = it }
            }

            Option(label = "Preferences", onOptionClicked = { println("Preferences clicked") })
            Option(label = "SignOut", onOptionClicked = { println("SignOut clicked") })
        }
    }

    @Composable
    fun Option(label: String, onOptionClicked: () -> Unit, content: @Composable (() -> Unit)? = null) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(55.dp, Alignment.End),
            modifier = Modifier.padding(start = 77.dp, bottom = 32.dp)
        ) {
            Text(
                text = label,
                style = TextStyle(
                    color = AppColors.TEXT,
                    fontSize = FontSizes.DEFAULT
                ),
                modifier = Modifier.clickable { onOptionClicked() }
            )

            content?.let { content() }
        }
    }

    @Composable
    fun ToggleSwitch(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
        val switchBorderShape = RoundedCornerShape(16.dp)
        val switchBackgroundColor = if (isChecked) AppColors.ACCENT else Color.Black

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = switchBorderShape
                )
                .background(
                    color = switchBackgroundColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .height(height = 25.dp)
        ) {
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackAlpha = 0f,
                    uncheckedTrackAlpha = 0f
                )
            )
        }
    }

    @Composable
    fun ProfileOptionsDivider() {
        Divider(
            color = AppColors.BORDER,
            thickness = 1.dp,
            modifier = Modifier.padding(
                start = 77.dp,
                top = 16.dp,
                bottom = 16.dp
            )
        )
    }

    @Composable
    fun EditProfileOption() {
        Row(Modifier.height(55.dp)) {
            ProfilePicture(60.dp)
            Spacer(Modifier.width(16.dp))
            ProfileInfo()
            Spacer(Modifier.weight(1f))
            EditButton()
        }
    }

    @Composable
    fun EditButton() {
        Text(
            text = "Edit",
            style = TextStyle(
                color = AppColors.PRIMARY,
                fontSize = FontSizes.SMALL
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }

    @Composable
    fun ProfileInfo() {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Profile",
                style = TextStyle(
                    color = AppColors.PRIMARY,
                    fontSize = FontSizes.SMALL
                )
            )

            Text(
                text = profileViewModel.username,
                style = TextStyle(
                    color = AppColors.TEXT,
                    fontSize = FontSizes.DEFAULT
                )
            )
        }
    }

    @Composable
    fun Gradients() {
        val radius = 800f
        BoxGradient(0f, 0f, AppColors.TOP_LEFT_GRADIENT, radius)
        BoxGradient(Float.POSITIVE_INFINITY, 140f, AppColors.TOP_RIGHT_GRADIENT, radius * 2)
        BoxGradient(300f, Float.POSITIVE_INFINITY, AppColors.BOTTOM_CENTER_GRADIENT, radius / 4)
        BoxGradient(100f, 700f, AppColors.BOTTOM_LEFT_GRADIENT, radius / 2)
        BoxGradient(Float.POSITIVE_INFINITY, 600f, AppColors.BOTTOM_RIGHT_GRADIENT, radius / 1.5f)
    }

    @Composable
    fun BoxGradient(x: Float, y: Float, color: Color, radius: Float) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(color, Color.Transparent),
                        center = Offset(x, y), // Top-left corner
                        radius = radius
                    )
                )
        )
    }

    @Composable
    fun ProfilePicture(size: Dp = 40.dp) {
        Image(
            painter = painterResource("profile-picture.png"),
            contentDescription = "Profile Image",
            modifier = Modifier.size(size)
        )
    }

    @Composable
    fun ProfileName() {
        Text(
            text = profileViewModel.username,
            style = TextStyle(
                color = AppColors.TEXT,
                fontSize = FontSizes.DEFAULT
            )
        )
    }
}