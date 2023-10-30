package io.graham.template

import android.content.Context
import co.touchlab.kmmbridgekickstart.AnalyticsHandle
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import io.graham.template.repository.TemplateRepository


internal fun templateStartup(context: Context, analyticsHandle: AnalyticsHandle): TemplateRepository {
    val locator = AndroidServiceLocator(context, analyticsHandle)
    return locator.templateRepository
}
internal class AndroidServiceLocator(
    context: Context,
    analyticsHandle: AnalyticsHandle
) : BaseServiceLocator(analyticsHandle) {

    override val settings: Settings by lazy {
        SharedPreferencesSettings(
            delegate = context.getSharedPreferences(
                SETTINGS_KEY,
                Context.MODE_PRIVATE
            )
        )
    }

    // Module specific initializers go here, e.g Sql Driver http client engine
}