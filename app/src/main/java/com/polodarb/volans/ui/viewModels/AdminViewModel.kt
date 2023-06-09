package com.polodarb.volans.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polodarb.volans.data.local.entities.Airport
import com.polodarb.volans.data.local.entities.Flight
import com.polodarb.volans.data.local.entities.Ticket
import com.polodarb.volans.data.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {

    private val _city = MutableStateFlow<CityUiState>(CityUiState.Loading)
    val city: StateFlow<CityUiState> = _city.asStateFlow()

    fun getCity() {
        viewModelScope.launch {
            repo.getSities().collect {
                _city.value = CityUiState.Success(it)
            }
        }
    }

    suspend fun addAirport(airport: Airport) {
        repo.addAirport(airport)
    }


    suspend fun addFlight(flight: Flight) {
        repo.addFlight(flight)
    }

}