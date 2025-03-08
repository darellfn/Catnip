package no.uio.ifi.in2000.darellfn.catnip.ui.facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.darellfn.catnip.data.facts.FactsDataSource
import no.uio.ifi.in2000.darellfn.catnip.data.facts.FactsRepository

class FactsViewModel : ViewModel() {
    private val repository = FactsRepository(factsDataSource = FactsDataSource())

    private val _fact = MutableStateFlow("")
    val fact: StateFlow<String> = _fact.asStateFlow()

    init {
        getFact()
    }

    fun getFact() {
        viewModelScope.launch {
            _fact.value = repository.getFact()
        }
    }
}