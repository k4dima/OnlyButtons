package core.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.onlybuttons.R

val PTSans = FontFamily(
    Font(R.font.ptsans_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.ptsans_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.ptsans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.ptsans_bolditalic, FontWeight.Bold, FontStyle.Italic)
)

val Inter = FontFamily(
    Font(R.font.inter_variable, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.inter_variable_italic, FontWeight.Normal, FontStyle.Italic)
)