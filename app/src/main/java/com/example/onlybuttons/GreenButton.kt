package com.example.onlybuttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlybuttons.ui.theme.PTSans

@Composable
fun GreenButton(onClick: () -> Unit, text: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val offset by animateDpAsState(if (pressed) 0.dp else (-20).dp)
    val sideShadowElevation by animateDpAsState(if (pressed) 0.dp else 4.dp)
    val roundedCornerShape = RoundedCornerShape(16.dp)
    val topColor by animateColorAsState(if (pressed) Color(0xEE_50B58D) else Color(0xDE_50B58D))
    val middleColor = Color(0xFF_50B58D)
    val bottomColor by animateColorAsState(if (pressed) Color(0xD9_50B58D) else Color(0xB3_50B58D))
    val sideColor = Color(0xFF_43A980)
    Box(
        Modifier
            .clickable(interactionSource, null, onClick = onClick)
            .size(224.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .shadow(sideShadowElevation, roundedCornerShape)
                .background(sideColor, roundedCornerShape)
        )
        Box(
            Modifier
                .fillMaxSize()
                .offset { IntOffset(0, offset.roundToPx()) }
                .background(
                    Brush.verticalGradient(
                        listOf(Color(122, 199, 168), Color(181, 224, 207)),
                    ),
                    roundedCornerShape
                )
                .border(1.dp, sideColor, roundedCornerShape),
            Alignment.Center
        ) {
            Box(
                Modifier
                    .size(222.dp, 219.dp)
                    .background(
                        Brush.verticalGradient(listOf(topColor, middleColor, bottomColor)),
                        RoundedCornerShape(15.dp)
                    ), Alignment.Center
            ) {
                Text(
                    text,
                    fontFamily = PTSans,
                    style = TextStyle(
                        Color.White,
                        38.sp,
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.1f),
                            offset = Offset(x = 0f, y = 1f),
                            blurRadius = 2f
                        )
                    )
                )
            }
        }
    }
}