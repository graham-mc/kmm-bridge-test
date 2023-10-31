package co.touchlab.kmmbridgekickstart

class TemplateAnalytics internal constructor() {
    fun templateSaidHello(id: Long) {
        sendEvent("templateSaidHello", "Id" to id)
    }

    fun notifiedUserOfDeadVersion(version: String) {
        sendEvent("notifiedUserOfDeadVersion", version to String)
    }
}