package com.youssefsaber.appetizetemp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun AppScaffold(
    content: @Composable (Modifier) -> Unit
)
