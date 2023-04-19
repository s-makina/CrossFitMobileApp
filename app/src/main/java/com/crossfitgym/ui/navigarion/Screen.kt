package com.crossfitgym.ui.navigarion

sealed class Screen(val route : String) {
    object Syncronizing : Screen("syncronizing_screen")
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object Home : Screen("home_screen")
    object SettingsPage : Screen("settings_screen")
}