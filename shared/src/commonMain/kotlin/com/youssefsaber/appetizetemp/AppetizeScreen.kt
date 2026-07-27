package com.youssefsaber.appetizetemp

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppetizeScreen(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    
    val blobOffset1 by infiniteTransition.animateValue(
        initialValue = (-50).dp,
        targetValue = 50.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val blobOffset2 by infiniteTransition.animateValue(
        initialValue = 50.dp,
        targetValue = (-50).dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F2027),
                        Color(0xFF203A43),
                        Color(0xFF2C5364)
                    )
                )
            )
    ) {
        // Background decorative blobs to show off the glass effect
        Box(
            modifier = Modifier
                .size(250.dp)
                .offset(x = blobOffset1, y = 100.dp + blobOffset2 / 2)
                .background(Color(0xFFE91E63).copy(alpha = 0.4f), CircleShape)
        )
        Box(
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 50.dp + blobOffset2, y = 50.dp + blobOffset1)
                .background(Color(0xFF2196F3).copy(alpha = 0.3f), CircleShape)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlassyContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Appetize.io",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Native iOS builds\nin your browser",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Experience the seamless integration of mobile and web with high-performance virtualization.",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(alpha = 0.2f),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth().height(56.dp)
                    ) {
                        Text("Launch iOS Build", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
