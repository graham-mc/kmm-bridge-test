package co.touchlab.kmmbridgekickstart

import io.graham.template.templateStartup

fun startSDK(analytics: Analytics): SDKHandle {
    val analyticsHandle = initAnalytics(analytics)
    return SDKHandle(
        appAnalytics = analyticsHandle.appAnalytics,
        templateAnalytics = analyticsHandle.templateAnalytics,
        templateRepository = templateStartup(analyticsHandle)
    )
}
