package com.example.authen.navigation

sealed class Screen(val route: String) {
    object homeScreen : Screen("home_screen")
    object signIn : Screen("signIn_screen")
    object signUp : Screen("signUp_screen")
}