package io.graham.template

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Template says: hello, ${platform.name}!"
    }
}