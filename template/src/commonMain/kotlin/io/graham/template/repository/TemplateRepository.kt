package io.graham.template.repository

import co.touchlab.kmmbridgekickstart.TemplateAnalytics
import io.graham.template.xapis.XAPISCredentials
import kotlinx.coroutines.delay


class TemplateRepository internal constructor (
    private val xapisCredentials: XAPISCredentials,
    private val templateAnalytics: TemplateAnalytics
) {

    suspend fun isCurrentVersionDead(): Boolean? {
        delay(5000)
        if (appIsOffline()) {
            return null
        }
        return true
    }

    private fun appIsOffline(): Boolean {
        return false
    }
}