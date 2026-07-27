package com.youssefsaber.appetizetemp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
actual fun AppScaffold(
    content: @Composable (Modifier) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Settings")
    val icons = listOf(Icons.Default.Home, Icons.Default.Settings)

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        content(Modifier.padding(innerPadding))
    }
}
