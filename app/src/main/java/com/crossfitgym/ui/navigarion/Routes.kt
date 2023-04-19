package com.crossfitgym.ui.navigarion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crossfitgym.ui.pages.HomePage
import com.crossfitgym.ui.pages.LoginScreen
import com.crossfitgym.ui.pages.SyncronizingPage

@Composable
fun Routing() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(route = Screen.Syncronizing.route) {
            SyncronizingPage()
        }

        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(route = Screen.Home.route) {
            HomePage()
        }
    }
}