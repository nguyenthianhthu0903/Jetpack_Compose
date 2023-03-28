package com.example.doctorapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.doctorapp.R
import com.example.doctorapp.Screen
import com.example.doctorapp.ui.theme.BackgroundColor
import com.example.doctorapp.ui.theme.Shapes
import com.example.doctorapp.ui.theme.TextColor

@Composable
fun LoginScreen(
    navController: NavController,
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(Modifier.fillMaxSize()) {
            Logo()
            LoginComponent(navController)
        }
    }
}

@Composable
fun Logo() {
    Row(horizontalArrangement = Arrangement.Start, modifier = Modifier
        .fillMaxWidth()
        .padding(top = 100.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_healthcare_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )
    }
}

@Composable
fun LoginComponent(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .shadow(
                elevation = 2.dp,
                shape = Shapes.medium,
                clip = true,
                spotColor = BackgroundColor
            )
            .padding(10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        HeaderLogin(navController)
        TextFieldForm(navController)
    }
}

@Composable
fun HeaderLogin(
    navController: NavController
) {
    Column() {
        Text(
            text = "Sign in",
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            color = TextColor
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Don't have an account?", color = TextColor)
            Text(text = "Get one", color = Color.Green, modifier = Modifier.clickable { navController.navigate(Screen.ScreenRegister.route) })
        }
    }
}

@Composable
fun TextFieldForm(
    navController: NavController
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var error by remember {
        mutableStateOf(false)
    }
    var message by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "", tint = TextColor) },
            placeholder = { Text("Input your email") },
            label = { Text("Email") },
            isError = error,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "", tint = TextColor) },
            placeholder = { Text("Input your password") },
            label = { Text("Password") },
            isError = error,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        if(message.isNotEmpty()){
            Text(text = message, color = Color.Red)
        }
        Text(text = "Forgot password?", modifier = Modifier.padding(vertical = 10.dp), color = TextColor)
        ExtendedFloatingActionButton(
            text = { Text(text = "Login") },
            backgroundColor = BackgroundColor,
            contentColor = TextColor,
            icon = {
                Icon(Icons.Filled.ArrowForward, contentDescription = "")
            },
            onClick = {
                      if(email == "admin@gmail.com" && password == "12345"){
                          navController.navigate(Screen.ScreenHome.route)
                      }else{
                          error = true
                          message = "Email or password is not correct!"
                      }
            },
        )
    }
}



