package com.cyfer.skillify.auth

class AuthRepository(private val api: AuthApiService) {

    suspend fun login(email: String, password: String) =
        api.login(LoginRequest(email, password))

    suspend fun register(name: String, email: String, password: String, role: String) =
        api.register(RegisterRequest(name, email, password, role))
}