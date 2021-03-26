package com.example.superheroes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.superheroes.ui.list.ListScreen
import com.example.superheroes.ui.login.LoginScreen

@Composable
fun ScreenNavigator() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "loginScreen") {

        composable("loginScreen") {
            LoginScreen(navController)
        }

        composable("listScreen") {
            ListScreen()
        }
    }
}