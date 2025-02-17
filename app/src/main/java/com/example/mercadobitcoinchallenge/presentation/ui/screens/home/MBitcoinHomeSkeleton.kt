package com.example.mercadobitcoinchallenge.presentation.ui.screens.home

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLight03
import com.example.mercadobitcoinchallenge.presentation.ui.theme.NeutralLightPure
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp16
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp24
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp4
import com.example.mercadobitcoinchallenge.presentation.ui.theme.dp60

@Composable
internal fun MBitcoinHomeSkeleton(isVisible: Boolean = true) {
    if (isVisible) Box(
        modifier = Modifier
            .background(NeutralLightPure)
            .padding(top = dp24)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp16),
            verticalArrangement = Arrangement.spacedBy(dp16)
        ) {
            Spacer(modifier = Modifier.height(dp24))

            (1..5).forEach { _ ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(dp60)
                        .background(NeutralLight03)
                        .shimmerBackground(RoundedCornerShape(dp4))
                )
            }
        }
    }
}

fun Modifier.shimmerBackground(shape: Shape = RectangleShape): Modifier = composed {
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 400f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
            RepeatMode.Restart
        ),
        label = "",
    )
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.4f),
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnimation, translateAnimation),
        end = Offset(translateAnimation + 100f, translateAnimation + 100f),
        tileMode = TileMode.Mirror,
    )
    return@composed this.then(background(brush, shape))
}

@Preview
@Composable
private fun MBitcoinHomeSkeletonPreview() {
    MBitcoinHomeSkeleton()
}