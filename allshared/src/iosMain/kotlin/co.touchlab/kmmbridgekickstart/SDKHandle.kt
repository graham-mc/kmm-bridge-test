package co.touchlab.kmmbridgekickstart

import co.touchlab.kmmbridgekickstart.repository.BreedRepository
import io.graham.template.HelloTemplate

data class SDKHandle(
    val breedRepository: BreedRepository,
    val appAnalytics: AppAnalytics,
    val breedAnalytics: BreedAnalytics,
    val helloTemplate: HelloTemplate
)
