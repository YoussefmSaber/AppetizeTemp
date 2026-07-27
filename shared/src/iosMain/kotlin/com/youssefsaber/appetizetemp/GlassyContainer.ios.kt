package com.youssefsaber.appetizetemp

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIBlurEffect
import platform.UIKit.UIBlurEffectStyle
import platform.UIKit.UIVisualEffectView
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GlassyContainer(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        UIKitView(
            factory = {
                val blurEffect = UIBlurEffect.effectWithStyle(UIBlurEffectStyle.UIBlurEffectStyleRegular)
                val visualEffectView = UIVisualEffectView(effect = blurEffect)
                visualEffectView.layer.cornerRadius = 16.0
                visualEffectView.layer.masksToBounds = true
                visualEffectView
            },
            modifier = Modifier.matchParentSize()
        )
        content()
    }
}
