package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercadobitcoinchallenge.R
import com.example.mercadobitcoinchallenge.presentation.mvi.MBitcoinAction
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Brand02
import com.example.mercadobitcoinchallenge.presentation.ui.theme.Typography
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp4
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp50
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp8
import com.example.mercadobitcoinchallenge.presentation.ui.theme.ibmSansSerifFamily

@Composable
internal fun MBitcoinErrorComponent(
    modifier: Modifier = Modifier,
    exception: Exception?,
    onUiEvent: (MBitcoinAction) -> Unit
) {

    if (exception != null)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(id = R.string.mb_default_error_message),
                    style = Typography.titleMedium.copy(
                        fontFamily = ibmSansSerifFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(dp8))
                Button(
                    onClick = { onUiEvent.invoke(MBitcoinAction.GetExchangeList) },
                    shape = RoundedCornerShape(dp8),
                    colors = ButtonDefaults.buttonColors(containerColor = Brand02),
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(dp50)
                        .padding(dp4)
                ) {
                    Text(
                        text = stringResource(R.string.mb_try_again_label)
                    )
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
private fun MBitcoinErrorComponentPreview() {
    MBitcoinErrorComponent(
        exception = Exception(),
        onUiEvent = {}
    )
}
