package green.ui.elements

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.github.k4dima.testio.core.ui.elements.composableAnimated
import kotlinx.serialization.Serializable

@Serializable
object GreenButtonRoute

fun NavController.navigateToGreenButton() = navigate(GreenButtonRoute)

fun NavGraphBuilder.greenButtonScreen(onBack: () -> Unit) =
    composableAnimated<GreenButtonRoute> { GreenButtonScreen(onBack) }