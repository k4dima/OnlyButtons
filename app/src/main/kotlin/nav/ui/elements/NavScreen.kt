package nav.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import core.ui.theme.OnlyButtonsTheme

@Preview
@Composable
private fun NavScreenPreview() = OnlyButtonsTheme { NavScreen({}, {}) }

@Composable
fun NavScreen(onGreen: () -> Unit, onBlue: () -> Unit) {
    Scaffold {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize(), Alignment.Center
        ) {
            Column(Modifier.width(IntrinsicSize.Min)) {
                val modifier = Modifier.fillMaxWidth()
                Button(onGreen, modifier) { Text("Green") }
                Button(onBlue, modifier) { Text("Blue") }
            }
        }
    }
}