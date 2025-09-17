package com.example.nit3213app.repository

import com.example.nit3213app.model.LoginRequest
import com.example.nit3213app.model.LoginResponse
import com.example.nit3213app.network.ApiService
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun login(username: String, password: String): LoginResponse {
        return try {
            api.login(LoginRequest(username, password))
        } catch (e: HttpException) {
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
