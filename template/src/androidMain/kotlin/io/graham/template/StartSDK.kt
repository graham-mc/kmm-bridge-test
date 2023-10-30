package io.graham.template

import android.content.Context
import co.touchlab.kmmbridgekickstart.Analytics
import co.touchlab.kmmbridgekickstart.initAnalytics

fun startTemplateSDK(analytics: Analytics, context: Context): SDKHandle {
    val analyticsHandle = initAnalytics(analytics)
    val templateRepository = templateStartup(context, analyticsHandle)
    return SDKHandle(
        templateRepository = templateRepository,
        appAnalytics = analyticsHandle.appAnalytics,
        templateAnalytics = analyticsHandle.templateAnalytics
    )
}