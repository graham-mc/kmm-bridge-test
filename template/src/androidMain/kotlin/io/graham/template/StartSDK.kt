package io.graham.template

import android.content.Context
import co.touchlab.kmmbridgekickstart.Analytics
import co.touchlab.kmmbridgekickstart.initAnalytics
import io.graham.template.xapis.XAPISCredentials

fun startTemplateSDK(analytics: Analytics, xapisCredentials: XAPISCredentials, context: Context): SDKHandle {
    val analyticsHandle = initAnalytics(analytics)
    val templateRepository = templateStartup(context, analyticsHandle, xapisCredentials)
    return SDKHandle(
        templateRepository = templateRepository,
        appAnalytics = analyticsHandle.appAnalytics,
        templateAnalytics = analyticsHandle.templateAnalytics
    )
}