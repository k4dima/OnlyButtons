package com.example.onlybuttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BlueButton(onClick: () -> Unit, text: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val backgroundColor
            by animateColorAsState(if (pressed) Color(0xDD_4A5B7C) else Color(0xFF_4A5B7C))
    val borderColor by animateColorAsState(if (pressed) Color(24, 26, 39) else Color(90, 110, 143))
    val roundedCornerShape = RoundedCornerShape(16.dp)
    val topColor by animateColorAsState(if (pressed) Color(63, 70, 101) else Color(95, 121, 162))
    val bottomColor by animateColorAsState(if (pressed) Color(63, 70, 101) else Color(82, 102, 138))
    val topBorderColor by animateColorAsState(if (pressed) borderColor else Color(112, 134, 172))
    val bottomBorderColor by animateColorAsState(if (pressed) borderColor else Color(90, 109, 144))
    val outerShadowAlpha by animateFloatAsState(if (pressed) 0f else 0.5f)
    val innerShadowAlpha by animateFloatAsState(if (pressed) 0.75f else 0f)
    Box {
        Image(
            painterResource(R.drawable.girl),
            null,
            Modifier
                .fillMaxSize()
                .blur(24.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier
                .background(backgroundColor)
                .fillMaxSize(),
            Alignment.Center
        ) {
            Box(
                Modifier
                    .clickable(interactionSource, null, onClick = onClick)
                    .size(150.dp, 52.dp)
                    .boxShadow(
                        Color.Black.copy(outerShadowAlpha),
                        4.dp,
                        offset = DpOffset(0.dp, 4.dp),
                        shape = roundedCornerShape
                    )
                    .innerShadow(
                        roundedCornerShape,
                        color = Color.Black.copy(innerShadowAlpha),
                        blur = 1.dp,
                        offsetX = 0.dp,
                        offsetY = 2.dp,
                        spread = 0.dp
                    )
                    .background(
                        Brush.verticalGradient(listOf(topBorderColor, bottomBorderColor)),
                        roundedCornerShape
                    ),
                Alignment.Center
            ) {
                Box(
                    Modifier
                        .size(147.dp, 49.dp)
                        .background(
                            Brush.verticalGradient(listOf(topColor, bottomColor)),
                            RoundedCornerShape(15.dp)
                        ),
                    Alignment.Center
                ) {
                    Text(text, color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}