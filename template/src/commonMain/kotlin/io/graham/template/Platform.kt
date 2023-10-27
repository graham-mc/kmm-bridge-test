package io.graham.template

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform