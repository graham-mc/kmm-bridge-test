package io.graham.template

import co.touchlab.kmmbridgekickstart.AnalyticsHandle
import co.touchlab.kmmbridgekickstart.AppAnalytics
import co.touchlab.kmmbridgekickstart.TemplateAnalytics
import com.russhwolf.settings.Settings
import io.graham.template.repository.TemplateRepository

internal const val SETTINGS_KEY = "TemplateSettings"

internal abstract class BaseServiceLocator(private val analyticsHandle: AnalyticsHandle): ServiceLocator {
    override val templateRepository: TemplateRepository by lazy {
        TemplateRepository(
            templateAnalytics = templateAnalytics
        )
    }

    override val appAnalytics: AppAnalytics
        get() = analyticsHandle.appAnalytics

    override val templateAnalytics: TemplateAnalytics
        get() = analyticsHandle.templateAnalytics

    protected abstract val settings: Settings
}