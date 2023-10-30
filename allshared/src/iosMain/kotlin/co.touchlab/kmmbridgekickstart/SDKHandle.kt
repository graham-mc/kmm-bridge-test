package co.touchlab.kmmbridgekickstart

import io.graham.template.repository.TemplateRepository

data class SDKHandle(
    val appAnalytics: AppAnalytics,
    val templateAnalytics: TemplateAnalytics,
    val templateRepository: TemplateRepository,
)
