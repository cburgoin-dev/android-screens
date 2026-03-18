package com.example.mainscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mainscreen.ui.theme.MainScreenTheme
import androidx.navigation.compose.*
import androidx.compose.runtime.Composable
import com.example.mainscreen.screens.LoginScreen
import com.example.mainscreen.screens.SignUpScreen
import com.example.mainscreen.screens.WelcomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MainScreenTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "welcome"
        ) {
            composable("welcome") {
                WelcomeScreen(navController)
            }

            composable("login") {
                LoginScreen(navController)
            }

            composable("signup") {
                SignUpScreen(navController)
            }
        }
    }
}