package com.example.doctorapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorapp.ui.theme.BackgroundColor
import com.example.doctorapp.ui.theme.BackgroundColor1
import com.example.doctorapp.ui.theme.PrimaryColor
import com.example.doctorapp.ui.theme.TextColor

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))
        ) {
            TopHeader()
            TopOptions()
        }
        Search()
        Banner()
        Options()
    }
}

@Composable
fun TopHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))
            .background(PrimaryColor)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .padding(start = 50.dp, top = 50.dp, end = 50.dp, bottom = 25.dp)
        ) {
            Column() {
                Text(text = "Hello", fontSize = 16.sp, color = Color.White)
                Text(text = "I'm Thu", fontSize = 24.sp, color = Color.White)
            }
            Image(
                painter = painterResource(id = com.example.doctorapp.R.drawable.profile),
                contentDescription = "profile",
                modifier = Modifier.clip(
                    RoundedCornerShape(100)
                )
            )
        }
    }
}


@Composable
fun TopOptions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp, start = 40.dp, end = 40.dp)
            .background(color = Color.White)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(BackgroundColor1)
                    .padding(5.dp)
                    .size(80.dp)
            ) {
                Image(
                    painter = painterResource(id = com.example.doctorapp.R.drawable.video_call),
                    contentDescription = "video_call",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Video Call",
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(BackgroundColor1)
                    .padding(5.dp)
                    .size(80.dp)
            ) {
                Image(
                    painter = painterResource(id = com.example.doctorapp.R.drawable.notification),
                    contentDescription = "notification",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Notification",
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(BackgroundColor1)
                    .padding(5.dp)
                    .size(80.dp)
            ) {
                Image(
                    painter = painterResource(id = com.example.doctorapp.R.drawable.voice_call),
                    contentDescription = "voice_call",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Voice Call",
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun Search() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = "Search for...",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        },
        trailingIcon = {
            Icon(Icons.Outlined.Search, contentDescription = null)
        },
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp, 25.dp)
    )
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp, 25.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = PrimaryColor)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 20.dp)
            ) {
                Text(
                    text = "To Get Unlimited",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                Text(
                    text = "Upgrade Your Account",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = com.example.doctorapp.R.drawable.logo),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
            )
        }
    }
}

@Preview
@Composable
fun Options() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(45.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.size(70.dp)
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_1),
                        contentDescription = "inbox",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Inbox", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_2),
                        contentDescription = "Map",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Map", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_3),
                        contentDescription = "chat",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Chat", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_4),
                        contentDescription = "Reports",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Reports", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            ) {
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_5),
                        contentDescription = "Calender",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Calender", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_6),
                        contentDescription = "Tips",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Tips", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_7),
                        contentDescription = "Setting",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Setting", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
                Column(
                    modifier = Modifier.size(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = com.example.doctorapp.R.drawable.ic_8),
                        contentDescription = "More",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "More", modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

