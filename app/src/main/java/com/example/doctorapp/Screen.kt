package com.example.doctorapp


sealed class Screen(val route: String) {
    //list of screen for
    object ScreenStart: Screen("start_screen")
    object ScreenHome: Screen("home_screen")
    object ScreenLogin: Screen("login_screen")
    object ScreenRegister: Screen("register_screen")
}
