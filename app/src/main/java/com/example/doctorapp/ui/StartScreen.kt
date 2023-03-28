package com.example.doctorapp.ui

import android.os.Looper
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.doctorapp.Screen
import com.example.doctorapp.ui.theme.BackgroundColor
import com.example.doctorapp.ui.theme.Shapes
import com.example.doctorapp.ui.theme.TextColor

@Composable
fun StartScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(BackgroundColor)
        ) {
            Image(
                painter = painterResource(id = com.example.doctorapp.R.drawable.ic_healthcare_logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                modifier = Modifier.clickable {
                },
                text = "Healthy App",
                style = MaterialTheme.typography.h4,
                color = TextColor,
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                          navController.navigate(Screen.ScreenLogin.route)
                },
                shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = TextColor
                ),
                border = BorderStroke(width = 1.dp, color = TextColor),
                contentPadding = PaddingValues(horizontal = 70.dp, vertical = 15.dp),
            ) {
                Text(text = "Sign in", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                          navController.navigate(Screen.ScreenRegister.route)
                },
                shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = TextColor
                ),
                border = BorderStroke(width = 1.dp, color = TextColor),
                contentPadding = PaddingValues(horizontal = 70.dp, vertical = 15.dp),
            ) {
                Text(text = "Sign up", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = BackgroundColor,
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.elevation(0.dp),
            ) {
                Image(
                    painter = painterResource(id = com.example.doctorapp.R.drawable.ic_google),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Continue with Google", fontSize = 16.sp)
            }

        }
    }
}

