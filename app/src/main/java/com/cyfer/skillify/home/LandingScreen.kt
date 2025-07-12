package com.cyfer.skillify.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cyfer.skillify.nav.Screen

@Composable
fun LandingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text("Welcome to Skillify", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(
                "Empowering personalized learning between students and teachers.",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Column {
            Text("🚀 Features", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("• Real-time session booking")
            Text("• Profile system for students & teachers")
            Text("• Availability & session management")
            Text("• In-app messaging (coming soon)")
            Text("• Reviews, ratings, and more!")
        }

        Column {
            Button(
                onClick = { navController.navigate(Screen.Login.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { navController.navigate(Screen.Register.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Register")
            }

            Spacer(modifier = Modifier.height(8.dp))
            ClickableText(
                text = AnnotatedString("Continue as Guest"),
                onClick = { /* Optional navigation to explore public content */ }
            )
        }
    }
}
