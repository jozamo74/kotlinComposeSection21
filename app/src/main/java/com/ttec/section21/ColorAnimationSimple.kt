package com.ttec.section21

import android.widget.Space
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ColorAnimationSimple() {
    Column {
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }
        var realColor = if (firstColor) Color.Red else Color.Yellow
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }
        )

        Spacer(modifier = Modifier.size(50.dp))

        var firstColor2 by rememberSaveable {
            mutableStateOf(false)
        }

        val realColor2 by animateColorAsState(
            targetValue = if (firstColor2) Color.Red else Color.Yellow, label = ""
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { firstColor2 = !firstColor2 }
        )

        Spacer(modifier = Modifier.size(50.dp))

        var firstColor3 by rememberSaveable {
            mutableStateOf(false)
        }

        var showBox by rememberSaveable {
            mutableStateOf(true)
        }

        val realColor3 by animateColorAsState(
            targetValue = if (firstColor3) Color.Red else Color.Yellow, label = "",
            animationSpec = tween(durationMillis = 2000),
            finishedListener = { showBox = false }
        )
        if (showBox) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColor3)
                    .clickable { firstColor3 = !firstColor3 }
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        var smallSize by rememberSaveable {
            mutableStateOf(true)
        }
        val size = if (smallSize) 50.dp else 100.dp

        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Cyan)
                .clickable { smallSize = !smallSize }
        )

        Spacer(modifier = Modifier.size(50.dp))

        var smallSize2 by rememberSaveable {
            mutableStateOf(true)
        }
        val size2 by animateDpAsState(
            targetValue =  if (smallSize2) 100.dp else 150.dp,
            animationSpec = tween(durationMillis = 1000), label = ""
        )

        Box(
            modifier = Modifier
                .size(size2)
                .background(Color.Cyan)
                .clickable { smallSize2 = !smallSize2 }
        )
    }

}


