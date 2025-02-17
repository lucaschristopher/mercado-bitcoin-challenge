package com.example.mercadobitcoinchallenge.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.mercadobitcoinchallenge.commons.extensions.DEFAULT_STRING
import com.example.mercadobitcoinchallenge.commons.extensions.SPACE_STRING
import com.example.mercadobitcoinchallenge.presentation.ui.theme.ibmSansMonoFamily

@Composable
internal fun CustomTextComponent(
    modifier: Modifier = Modifier,
    firstString: String,
    secondString: String
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = ibmSansMonoFamily,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(firstString)
            }
            append(SPACE_STRING)
            withStyle(
                style = SpanStyle(
                    fontFamily = ibmSansMonoFamily,
                    fontWeight = FontWeight.Normal
                )
            ) {
                append(secondString.ifBlank { DEFAULT_STRING })
            }
        }
    )
}
