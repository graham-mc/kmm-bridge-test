package io.graham.template

import co.touchlab.kmmbridgekickstart.AnalyticsHandle
import co.touchlab.kmmbridgekickstart.AppAnalytics
import co.touchlab.kmmbridgekickstart.TemplateAnalytics
import com.russhwolf.settings.Settings
import io.graham.template.repository.TemplateRepository
import io.graham.template.xapis.XAPISCredentials

internal const val SETTINGS_KEY = "TemplateSettings"

internal abstract class BaseServiceLocator(private val analyticsHandle: AnalyticsHandle, private val xapisCredentials: XAPISCredentials): ServiceLocator {
    override val templateRepository: TemplateRepository by lazy {
        TemplateRepository(
            xapisCredentials = xapisCredentials,
            templateAnalytics = templateAnalytics
        )
    }

    override val appAnalytics: AppAnalytics
        get() = analyticsHandle.appAnalytics

    override val templateAnalytics: TemplateAnalytics
        get() = analyticsHandle.templateAnalytics

    protected abstract val settings: Settings
}