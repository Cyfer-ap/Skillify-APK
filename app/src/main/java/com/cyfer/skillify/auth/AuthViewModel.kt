package com.cyfer.skillify.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val token: String) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _state = MutableStateFlow<AuthState>(AuthState.Idle)
    val state: StateFlow<AuthState> = _state

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val response = repository.login(email, password)
            _state.value = if (response.isSuccessful) {
                AuthState.Success(response.body()?.token ?: "")
            } else {
                AuthState.Error("Login failed")
            }
        }
    }

    fun register(name: String, email: String, password: String, role: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val response = repository.register(name, email, password, role)
            _state.value = if (response.isSuccessful) {
                AuthState.Success(response.body()?.token ?: "")
            } else {
                AuthState.Error("Registration failed")
            }
        }
    }
}