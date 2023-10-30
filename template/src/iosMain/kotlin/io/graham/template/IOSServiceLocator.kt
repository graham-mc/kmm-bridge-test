package io.graham.template

import co.touchlab.kmmbridgekickstart.AnalyticsHandle
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import io.graham.template.repository.TemplateRepository
import platform.Foundation.NSUserDefaults

fun templateStartup(analyticsHandle: AnalyticsHandle): TemplateRepository {
    val locator = IOSServiceLocator(NSUserDefaults(suiteName = SETTINGS_KEY), analyticsHandle = analyticsHandle)
    return locator.templateRepository
}

internal class IOSServiceLocator(
    userDefaults: NSUserDefaults,
    analyticsHandle: AnalyticsHandle
) : BaseServiceLocator(analyticsHandle) {

    override val settings: Settings by lazy { NSUserDefaultsSettings(userDefaults) }
}