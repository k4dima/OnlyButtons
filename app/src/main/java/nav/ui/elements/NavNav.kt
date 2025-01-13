package nav.ui.elements

import androidx.navigation.NavGraphBuilder
import com.github.k4dima.testio.core.ui.elements.composableAnimated
import kotlinx.serialization.Serializable

@Serializable
object NavRoute

fun NavGraphBuilder.navScreen(onGreen: () -> Unit, onBlue: () -> Unit) =
    composableAnimated<NavRoute> { NavScreen(onGreen, onBlue) }