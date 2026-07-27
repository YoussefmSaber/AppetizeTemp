package com.youssefsaber.appetizetemp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.*

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun AppScaffold(
    content: @Composable (Modifier) -> Unit
) {
    UIKitViewController(
        factory = {
            val tabBarController = UITabBarController()
            
            // Apply Liquid Glass (Blur) to the TabBar
            val appearance = UITabBarAppearance()
            appearance.configureWithDefaultBackground()
            // Standard blur style for iOS
            tabBarController.tabBar.standardAppearance = appearance
            tabBarController.tabBar.scrollEdgeAppearance = appearance
            
            val homeViewController = MainViewController {
                content(Modifier.fillMaxSize())
            }
            homeViewController.tabBarItem = UITabBarItem(
                title = "Home",
                image = UIImage.systemImageNamed("house"),
                tag = 0
            )

            val settingsViewController = MainViewController {
                Box(Modifier.fillMaxSize())
            }
            settingsViewController.tabBarItem = UITabBarItem(
                title = "Settings",
                image = UIImage.systemImageNamed("gearshape"),
                tag = 1
            )

            tabBarController.viewControllers = listOf(homeViewController, settingsViewController)
            tabBarController
        },
        modifier = Modifier.fillMaxSize()
    )
}
