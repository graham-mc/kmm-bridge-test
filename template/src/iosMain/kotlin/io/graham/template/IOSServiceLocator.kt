package io.graham.template

import co.touchlab.kmmbridgekickstart.AnalyticsHandle
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import io.graham.template.repository.TemplateRepository
import io.graham.template.xapis.XAPISCredentials
import platform.Foundation.NSUserDefaults

fun templateStartup(analyticsHandle: AnalyticsHandle, xapisCredentials: XAPISCredentials): TemplateRepository {
    val locator = IOSServiceLocator(
        NSUserDefaults(suiteName = SETTINGS_KEY),
        analyticsHandle = analyticsHandle,
        xapisCredentials = xapisCredentials
    )
    return locator.templateRepository
}

internal class IOSServiceLocator(
    userDefaults: NSUserDefaults,
    analyticsHandle: AnalyticsHandle,
    xapisCredentials: XAPISCredentials
) : BaseServiceLocator(analyticsHandle, xapisCredentials) {

    override val settings: Settings by lazy { NSUserDefaultsSettings(userDefaults) }
}