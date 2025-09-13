package com.example.nit3213app.repository

import com.example.nit3213app.model.LoginRequest
import com.example.nit3213app.model.LoginResponse
import com.example.nit3213app.network.RetrofitClient
import retrofit2.HttpException

class LoginRepository {
    private val api = RetrofitClient.api

    suspend fun login(username: String, password: String): LoginResponse {
        return try {
            api.login(LoginRequest(username, password))
        } catch (e: HttpException) {
            // If API returns 404 or invalid credentials
            if (e.code() == 404) {
                throw Exception("Incorrect username or password")
            } else {
                throw Exception("Login failed: ${e.message()}")
            }
        } catch (e: Exception) {
            throw Exception("Login failed: ${e.message}")
        }
    }
}
