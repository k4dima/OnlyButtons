package blue.ui.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlybuttons.R
import core.ui.elements.boxShadow
import core.ui.elements.innerShadow
import core.ui.theme.Inter

@Preview
@Composable
private fun BlueButtonPreview() {
    BlueButton({}, "Cancel")
}

@Composable
fun BlueButton(onClick: () -> Unit, text: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val backgroundColor
            by animateColorAsState(if (pressed) Color(0xD1_0D1A35) else Color(0xFF_4A5B7C))
    val borderColor by animateColorAsState(if (pressed) Color(24, 26, 39) else Color(90, 110, 143))
    val cornerSize = 16.dp
    val roundedCornerShape = RoundedCornerShape(cornerSize)
    val topColor by animateColorAsState(if (pressed) Color(63, 70, 101) else Color(95, 121, 162))
    val bottomColor by animateColorAsState(if (pressed) Color(63, 70, 101) else Color(82, 102, 138))
    val topBorderColor by animateColorAsState(if (pressed) borderColor else Color(112, 134, 172))
    val bottomBorderColor by animateColorAsState(if (pressed) borderColor else Color(90, 109, 144))
    val outerShadowAlpha by animateFloatAsState(if (pressed) 0f else 0.5f)
    val innerShadowAlpha by animateFloatAsState(if (pressed) 0.6f else 0f)
    val offset by animateDpAsState(if (pressed) (-2).dp else 0.dp)
    Box {
        Image(
            painterResource(R.drawable.girl),
            null,
            Modifier
                .fillMaxSize()
                .blur(48.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier
                .drawBehind { drawRect(backgroundColor) }
                .fillMaxSize(),
            Alignment.Center
        ) {
            Box(
                Modifier
                    .offset { IntOffset(0, offset.roundToPx()) }
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
                    .drawBehind {
                        val cornerRadius = cornerSize.toPx()
                        drawRoundRect(
                            Brush.verticalGradient(listOf(topBorderColor, bottomBorderColor)),
                            cornerRadius = CornerRadius(cornerRadius)
                        )
                    },
                Alignment.Center
            ) {
                Box(
                    Modifier
                        .size(148.dp, 50.dp)
                        .drawBehind {
                            val cornerRadius = 15.dp.toPx()
                            drawRoundRect(
                                Brush.verticalGradient(listOf(topColor, bottomColor)),
                                cornerRadius = CornerRadius(cornerRadius)
                            )
                        },
                    Alignment.Center
                ) {
                    Text(
                        text,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Inter
                    )
                }
            }
        }
    }
}