package green.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.k4dima.testio.core.ui.elements.navigationIcon
import core.ui.theme.OnlyButtonsTheme

@Preview
@Composable
private fun GreenButtonScreenPreview() = OnlyButtonsTheme { GreenButtonScreen(onBack = {}) }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreenButtonScreen(onBack: () -> Unit) {
    Scaffold(topBar = { TopAppBar({}, navigationIcon = navigationIcon(onBack)) }) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(it), Alignment.Center
        ) {
            GreenButton({}, "Старт")
        }
    }
}