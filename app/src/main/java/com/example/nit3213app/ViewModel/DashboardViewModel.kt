package com.example.nit3213app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nit3213app.model.DashboardResponse
import com.example.nit3213app.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _dashboardData = MutableStateFlow<DashboardResponse?>(null)
    val dashboardData: StateFlow<DashboardResponse?> get() = _dashboardData

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboard(keypass)
                _dashboardData.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
