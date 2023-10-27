package co.touchlab.kmmbridgekickstart

import io.graham.template.HelloTemplate

fun startSDK(analytics: Analytics): SDKHandle {
    val analyticsHandle = initAnalytics(analytics)
    return SDKHandle(
        breedRepository = breedStartup(analyticsHandle),
        appAnalytics = analyticsHandle.appAnalytics,
        breedAnalytics = analyticsHandle.breedAnalytics,
        helloTemplate = HelloTemplate()
    )
}

fun sayHello() = "Hello from Kotlin!"