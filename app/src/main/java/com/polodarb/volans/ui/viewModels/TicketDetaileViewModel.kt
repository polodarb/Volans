package com.polodarb.volans.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polodarb.volans.data.local.FlightCard
import com.polodarb.volans.data.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TicketDetaileViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow<FlightDetailUiState>(FlightDetailUiState.Loading)
    val state: StateFlow<FlightDetailUiState> = _state.asStateFlow()

    fun getTicketByFlightCode(flightCode: Int) {
        viewModelScope.launch {
            repository.getTicketByFlightCode(flightCode).collect { uiStates ->
                _state.value = FlightDetailUiState.Success(uiStates)
            }
        }
    }

//    suspend fun getFlightCard(flight: Int): FlightCard {
//        return repository.getFlightCard(flight)
//    }

//    suspend fun addBuyTicket(ticket: FlightCard) {
//        repository.addBuyTicket(ticket)
//    }
}