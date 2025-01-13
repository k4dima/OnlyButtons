package blue.ui.elements

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.github.k4dima.testio.core.ui.elements.composableAnimated
import kotlinx.serialization.Serializable

@Serializable
object BlueButtonRoute

fun NavController.navigateToBlueButton() = navigate(BlueButtonRoute)

fun NavGraphBuilder.blueButtonScreen(onBack: () -> Unit) =
    composableAnimated<BlueButtonRoute> { BlueButtonScreen(onBack) }