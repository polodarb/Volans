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
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state.asStateFlow()

    private val _city = MutableStateFlow<CityUiState>(CityUiState.Loading)
    val city: StateFlow<CityUiState> = _city.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllTickets().collect { uiStates ->
                _state.value = UiState.Success(uiStates)
            }
        }
    }

    fun getCity() {
        viewModelScope.launch {
            repository.getSities().collect {
                _city.value = CityUiState.Success(it)
            }
        }
    }

}