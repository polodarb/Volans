package com.polodarb.volans.ui.viewModels

import com.polodarb.volans.data.local.FlightCard

sealed class UiState {
    object Loading : UiState()

    data class Success(val flight: List<FlightCard>) : UiState()

    data class Error(val throwable: String) : UiState()
}