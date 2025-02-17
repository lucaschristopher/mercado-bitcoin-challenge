package com.example.mercadobitcoinchallenge.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mercadobitcoinchallenge.R

// Set of Material typography styles to start with
val ibmSansMonoFamily = FontFamily(
    Font(R.font.imb_plex_mono_semibold, FontWeight.SemiBold),
    Font(R.font.ibm_plex_mono_light, FontWeight.Light),
    Font(R.font.ibm_plex_mono_thin, FontWeight.Thin),
)

val ibmSansSerifFamily = FontFamily(
    Font(R.font.ibm_plex_serif_semibold, FontWeight.SemiBold),
    Font(R.font.ibm_plex_serif_thin, FontWeight.Thin)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)