package com.enike.wetha.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.enike.wetha.R

// Set of Material typography styles to start with

private val CircularStd = FontFamily(
    Font(R.font.circular_std_book, FontWeight.Light),
    Font(R.font.circular_std_bold, FontWeight.Bold)
)

val Typography = Typography(
    h4 = TextStyle(
        fontFamily = CircularStd,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    body1 = TextStyle(
        fontFamily = CircularStd,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)