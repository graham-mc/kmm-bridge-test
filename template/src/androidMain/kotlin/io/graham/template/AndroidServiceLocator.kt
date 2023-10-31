package io.graham.template

import android.content.Context
import co.touchlab.kmmbridgekickstart.AnalyticsHandle
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import io.graham.template.repository.TemplateRepository
import io.graham.template.xapis.XAPISCredentials


internal fun templateStartup(context: Context, analyticsHandle: AnalyticsHandle, xapisCredentials: XAPISCredentials): TemplateRepository {
    val locator = AndroidServiceLocator(context, analyticsHandle, xapisCredentials)
    return locator.templateRepository
}
internal class AndroidServiceLocator(
    context: Context,
    analyticsHandle: AnalyticsHandle,
    xapisCredentials: XAPISCredentials,
) : BaseServiceLocator(analyticsHandle, xapisCredentials) {

    override val settings: Settings by lazy {
        SharedPreferencesSettings(
            delegate = context.getSharedPreferences(
                SETTINGS_KEY,
                Context.MODE_PRIVATE
            )
        )
    }
}