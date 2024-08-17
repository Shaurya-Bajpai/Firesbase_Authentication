package com.example.authen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authen.AuthenViewModel
import com.example.authen.pages.HomeScreen
import com.example.authen.pages.SignIn
import com.example.authen.pages.SignUp

@Composable
fun NavigationControl(
    viewModel: AuthenViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.signUp.route
    ) {

        composable(Screen.signUp.route) {
            SignUp(viewModel = viewModel, navController = navController)
        }

        composable(Screen.signUp.route) {
            SignIn(viewModel = viewModel, navController = navController)
        }

        composable(Screen.signUp.route) {
            HomeScreen(viewModel = viewModel)
        }
    }
}