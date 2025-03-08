package no.uio.ifi.in2000.darellfn.catnip.data.facts

class FactsRepository(private val factsDataSource: FactsDataSource) {
    suspend fun getFact() : String {
        val fact = factsDataSource.getData().data.firstOrNull()
        return fact?:"No data fetched...meow"
    }
}