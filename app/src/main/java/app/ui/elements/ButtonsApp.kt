package app.ui.elements

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import blue.ui.elements.blueButtonScreen
import blue.ui.elements.navigateToBlueButton
import core.ui.theme.OnlyButtonsTheme
import green.ui.elements.greenButtonScreen
import green.ui.elements.navigateToGreenButton
import nav.ui.elements.NavRoute
import nav.ui.elements.navScreen

@Preview
@Composable
private fun ButtonsAppPreview() = OnlyButtonsTheme { ButtonsApp() }

@Composable
fun ButtonsApp() = ButtonsNavHost()

@Composable
fun ButtonsNavHost() {
    val navController = rememberNavController()
    NavHost(navController, NavRoute) {
        navScreen(navController::navigateToGreenButton, navController::navigateToBlueButton)
        blueButtonScreen(navController::popBackStack)
        greenButtonScreen(navController::popBackStack)
    }
}