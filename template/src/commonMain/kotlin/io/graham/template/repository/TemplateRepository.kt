package io.graham.template.repository

import co.touchlab.kmmbridgekickstart.TemplateAnalytics


class TemplateRepository internal constructor (
    private val templateAnalytics: TemplateAnalytics
) {
    fun helloTemplate(): String {
        templateAnalytics.templateSaidHello(42)
        return "Template says hello!"
    }
}