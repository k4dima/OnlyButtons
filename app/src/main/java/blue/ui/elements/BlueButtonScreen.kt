package blue.ui.elements

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.github.k4dima.testio.core.ui.elements.navigationIcon
import core.ui.theme.OnlyButtonsTheme

@Preview
@Composable
private fun BlueButtonScreenPreview() = OnlyButtonsTheme { BlueButtonScreen(onBack = {}) }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlueButtonScreen(onBack: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            {},
            navigationIcon = navigationIcon(onBack),
            colors = topAppBarColors(Color.Transparent)
        )
    }) {
        BlueButton({}, "Cancel")
    }
}