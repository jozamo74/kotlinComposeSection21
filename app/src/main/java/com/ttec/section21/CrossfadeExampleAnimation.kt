package com.ttec.section21

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ttec.section21.ComponentType.*
import kotlin.random.Random.Default.nextInt

@Preview
@Composable
fun CrossfadeExampleAnimation() {

    var myComponentType: ComponentType by remember {
        mutableStateOf(Text)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }
        Crossfade(targetState = myComponentType) {

            when (it) {
                Image -> {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "")
                }

                Text -> Text(text = "Soy un componente")
                Box -> {
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .background(Color.Red)
                    )
                }

                Error -> Text(text = "ERRORRRR")
            }
        }
    }

}

fun getComponentTypeRandom(): ComponentType {

    val myNumber = nextInt(from = 0, until = 3)

    return when(myNumber) {
        0 -> Image
        1 -> Text
        2 -> Box
        else -> Error

    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}