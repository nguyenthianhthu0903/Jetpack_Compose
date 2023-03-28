package com.example.doctorapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.doctorapp.ui.HomeScreen
import com.example.doctorapp.ui.LoginScreen
import com.example.doctorapp.ui.RegisterScreen
import com.example.doctorapp.ui.StartScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
    startDestination = Screen.ScreenStart.route){
        composable(
            route = Screen.ScreenStart.route
        ){
           StartScreen(navController = navController)
        }
        composable(
            route = Screen.ScreenHome.route
        ){
            HomeScreen()
        }
        composable(
            route = Screen.ScreenLogin.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.ScreenRegister.route
        ){
            RegisterScreen(navController = navController)
        }
    }
}