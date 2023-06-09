package com.polodarb.volans.ui.viewModels

import com.polodarb.volans.data.local.FlightDetails
import com.polodarb.volans.data.local.entities.Flight

sealed class FlightDetailUiState {
    object Loading : FlightDetailUiState()

    data class Success(val ticket: FlightDetails) : FlightDetailUiState()

    data class Error(val throwable: String) : FlightDetailUiState()
}