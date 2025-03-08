package no.uio.ifi.in2000.darellfn.catnip.model.facts

import kotlinx.serialization.Serializable

@Serializable
data class CatFact(
    val data: List<String>
)
