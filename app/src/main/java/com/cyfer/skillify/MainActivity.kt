package com.cyfer.skillify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.cyfer.skillify.auth.AuthApiService
import com.cyfer.skillify.auth.AuthRepository
import com.cyfer.skillify.auth.AuthViewModel
import com.cyfer.skillify.nav.AppNavGraph
import com.cyfer.skillify.ui.theme.SkillifyTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkillifyTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    // ✅ Replace this with your actual IP and port of Django server
                    val retrofit = Retrofit.Builder()
                        .baseUrl("http://192.168.1.100:8000/")  // Replace with your local IP
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val authService = retrofit.create(AuthApiService::class.java)
                    val authViewModel = AuthViewModel(AuthRepository(authService))

                    val navController = rememberNavController()
                    AppNavGraph(navController = navController, authViewModel = authViewModel)
                }
            }
        }
    }
}
