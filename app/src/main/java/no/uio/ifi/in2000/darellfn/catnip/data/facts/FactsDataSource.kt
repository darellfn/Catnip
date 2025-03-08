package no.uio.ifi.in2000.darellfn.catnip.data.facts

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.darellfn.catnip.model.facts.CatFact

class FactsDataSource {
    val ktorHttpClient = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getData() : CatFact {
        val fetchedData: CatFact = ktorHttpClient.get("https://meowfacts.herokuapp.com")
        Log.d("API", "fetched data: $fetchedData")
        return fetchedData
    }
}