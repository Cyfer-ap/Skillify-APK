package com.cyfer.skillify.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// Request data models
data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val role: String
)

// Response data model
data class AuthResponse(
    val token: String
)

// Retrofit API interface
interface AuthApiService {
    @POST("auth/login/")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("auth/register/")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

}
