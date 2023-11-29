package com.jetbrains.kmp

import platform.UIKit.UIDevice
import cocoapods.AFNetworking

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()