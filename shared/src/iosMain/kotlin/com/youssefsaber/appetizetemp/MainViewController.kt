package com.youssefsaber.appetizetemp

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun MainViewController(content: @Composable () -> Unit): UIViewController = ComposeUIViewController {
    content()
}

fun MainAppController() = MainViewController { App() }
