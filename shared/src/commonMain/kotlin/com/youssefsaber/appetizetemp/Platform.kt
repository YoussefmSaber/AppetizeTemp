package com.youssefsaber.appetizetemp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform