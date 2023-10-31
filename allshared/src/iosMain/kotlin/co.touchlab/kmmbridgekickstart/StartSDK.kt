package co.touchlab.kmmbridgekickstart

import io.graham.template.templateStartup
import io.graham.template.xapis.XAPISCredentials

fun startSDK(analytics: Analytics, xapisCredentials: XAPISCredentials): SDKHandle {
    val analyticsHandle = initAnalytics(analytics)
    return SDKHandle(
        appAnalytics = analyticsHandle.appAnalytics,
        templateAnalytics = analyticsHandle.templateAnalytics,
        templateRepository = templateStartup(analyticsHandle, xapisCredentials)
    )
}
