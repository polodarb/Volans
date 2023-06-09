package com.polodarb.volans.ui.viewModels

import com.polodarb.volans.data.local.FlightCard

sealed class CityUiState {
    object Loading : CityUiState()

    data class Success(val flight: List<String>) : CityUiState()

    data class Error(val throwable: String) : CityUiState()
}