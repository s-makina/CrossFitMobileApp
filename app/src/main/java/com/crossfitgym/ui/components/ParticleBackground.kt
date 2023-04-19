package com.crossfitgym.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun ParticleBackground() {
    val particles = remember { mutableListOf<Particle>() }
    val colors = remember { arrayOf(
        Color(0xFFE57373),
        Color(0xFFBA68C8),
        Color(0xFF64B5F6),
        Color(0xFFFFB74D),
        Color(0xFF4DB6AC)
    ) }

    DisposableEffect(true) {
        onDispose {
            particles.clear()
            // Perform cleanup here
        }
    }

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {


//        drawRect(Color.Black)

        if (particles.size < 20) {
            particles.addAll((0..20).map {
                Particle(
                    x = (0..size.width.toInt()).random().toFloat(),
                    y = (0..size.height.toInt()).random().toFloat(),
                    color = colors.random(),
                    size = 5f,
                    speed = 0.1f
                )
            })
        }

        particles.forEach {
            drawCircle(
                color = it.color,
                radius = it.size,
                center = Offset(it.x, it.y)
            )
            it.move(size.width, size.height)
        }

        particles.removeAll { it.size <= 0 }
    }
}

data class Particle(
    var x: Float,
    var y: Float,
    var color: Color,
    var speed: Float,
    var size: Float
) {
    fun move(width: Float, height: Float) {
        x += speed
        y += speed

        if (x > width || y > height) {
            x = 0f
            y = 0f
        }

        size -= 0.1f
    }
}