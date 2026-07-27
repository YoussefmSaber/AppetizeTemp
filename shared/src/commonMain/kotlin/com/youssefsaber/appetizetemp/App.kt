package com.youssefsaber.appetizetemp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppScaffold { modifier ->
            AppetizeScreen(modifier)
        }
    }
}
