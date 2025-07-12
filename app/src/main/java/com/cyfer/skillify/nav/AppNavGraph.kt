package com.cyfer.skillify.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cyfer.skillify.auth.AuthViewModel
import com.cyfer.skillify.auth.LoginScreen
import com.cyfer.skillify.auth.RegisterScreen
import androidx.compose.material3.Text // ✅ Fixed import for Material 3 Text
import com.cyfer.skillify.home.LandingScreen

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object Login : Screen("login")
    object Register : Screen("register")
    object Dashboard : Screen("dashboard")
}


@Composable
fun AppNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = Screen.Landing.route) {

        composable(Screen.Landing.route) {
            LandingScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(viewModel = authViewModel) {
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            }
        }

        composable(Screen.Register.route) {
            RegisterScreen(viewModel = authViewModel) {
                navController.navigate(Screen.Dashboard.route) {
                    popUpTo(Screen.Register.route) { inclusive = true }
                }
            }
        }

        composable(Screen.Dashboard.route) {
            Text("Welcome to Skillify Dashboard!")
        }
    }
}
