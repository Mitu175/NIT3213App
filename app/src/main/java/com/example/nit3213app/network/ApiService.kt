package com.example.nit3213app.network


import com.example.nit3213app.model.LoginRequest
import com.example.nit3213app.model.LoginResponse
import com.example.nit3213app.model.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @POST("footscray/auth")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("/dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): DashboardResponse



}
