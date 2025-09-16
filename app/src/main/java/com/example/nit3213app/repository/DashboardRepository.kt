package com.example.nit3213app.repository

import com.example.nit3213app.model.DashboardResponse
import com.example.nit3213app.network.ApiService
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getDashboard(keypass: String): DashboardResponse {
        return apiService.getDashboard(keypass)
    }
}
