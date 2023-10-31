package io.graham.template.response

import kotlinx.serialization.Serializable

@Serializable
data class DeadVersionsResult(
    val deadVersions: List<String>
)
