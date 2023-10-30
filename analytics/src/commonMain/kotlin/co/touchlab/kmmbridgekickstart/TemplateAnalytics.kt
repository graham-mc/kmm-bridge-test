package co.touchlab.kmmbridgekickstart

class TemplateAnalytics internal constructor() {
    fun templateSaidHello(id: Long) {
        sendEvent("templateSaidHello", "Id" to id)
    }
}