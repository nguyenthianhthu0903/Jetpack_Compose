package com.example.doctorapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
fun RegisterScreen(
    navController: NavController,
) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(Modifier.fillMaxSize()) {
            LogoRegister()
            RegisterComponent(navController)
        }
    }
}

@Composable
fun LogoRegister() {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo1),
            contentDescription = "Logo",
            modifier = Modifier.size(140.dp)
        )
    }
}

@Composable
fun RegisterComponent(navController: NavController) {
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
        HeaderRegister(navController)
        TextFieldRegisterForm(navController)
    }
}

@Composable
fun HeaderRegister(
    navController: NavController
) {
    Column() {
        Text(
            text = "Create Account",
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            color = TextColor
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Already have an account?", color = TextColor)
            Text(
                text = "Sign in",
                color = Color.Blue,
            modifier = Modifier.clickable { navController.navigate(Screen.ScreenLogin.route) })
        }
    }
}

@Composable
fun TextFieldRegisterForm(
    navController: NavController
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf("")
    }
    var isError by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "", tint = TextColor) },
            placeholder = { Text("Input your email") },
            isError = isError and ("Email" in message),
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "", tint = TextColor) },
            placeholder = { Text("Input your password") },
            label = { Text("Password") },
            isError = isError and ("Password" in message),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "", tint = TextColor) },
            placeholder = { Text("Input your confirm password") },
            label = { Text("Confirm Password") },
            isError = isError and ("Password" in message),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            leadingIcon = { Icon(Icons.Filled.Phone, contentDescription = "", tint = TextColor) },
            placeholder = { Text("Input your phone number") },
            label = { Text("Phone Number") },
            isError = isError and ("Phone" in message),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (message.isNotEmpty()) {
            Text(text = message, color = Color.Red)
        }
        ExtendedFloatingActionButton(
            text = { Text(text = "Register") },
            backgroundColor = BackgroundColor,
            contentColor = TextColor,
            icon = {
                Icon(Icons.Filled.ArrowForward, contentDescription = "")
            },
            onClick = {
                if ("@gmail.com" !in email) {
                    isError = true
                    message = "Email is not correct!"
                }
                else if(password.length < 5){
                    isError = true
                    message = "Password length must to have least 5 character"
                }
                else if (password != confirmPassword) {
                    isError = true
                    message = "Password is not match"
                }
                else if(phoneNumber.length != 10){
                    isError = true
                    message = "Phone number is not correct"
                }else{
                    navController.navigate(Screen.ScreenLogin.route)
                }
            },
        )
    }
}



