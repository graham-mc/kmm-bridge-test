package io.graham.template

import co.touchlab.kmmbridgekickstart.AppAnalytics
import co.touchlab.kmmbridgekickstart.TemplateAnalytics
import io.graham.template.repository.TemplateRepository

data class SDKHandle(
    val templateRepository: TemplateRepository,
    val appAnalytics: AppAnalytics,
    val templateAnalytics: TemplateAnalytics
)
