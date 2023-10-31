package io.graham.template.repository

import co.touchlab.kmmbridgekickstart.TemplateAnalytics
import io.graham.template.response.DeadVersionsResult
import io.graham.template.xapis.XAPISCredentials
import kotlinx.coroutines.delay


class TemplateRepository internal constructor (
    private val xapisCredentials: XAPISCredentials,
    private val templateAnalytics: TemplateAnalytics
) {

    suspend fun isCurrentVersionDead(): Boolean? {
        val result = retrieveDeadVersions() ?: return null
        if (result.contains(xapisCredentials.currentAppVersion)) {
            templateAnalytics.notifiedUserOfDeadVersion(xapisCredentials.currentAppVersion)
            return true
        }
        return false
    }

    private suspend fun retrieveDeadVersions(): List<String>? {
//        delay(2000)
        val json = """
        {
            "deadVersions": [
                "0.1",
                "0.2"
            ]
        }
        """
        val result = kotlinx.serialization.json.Json.decodeFromString<DeadVersionsResult>(json)
        return result.deadVersions
    }
}