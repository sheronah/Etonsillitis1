package com.example.etonsillitis.screens.Accounts

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.etonsillitis.R
import com.example.etonsillitis.Dashboard

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Recovery(context: Context, coroutine: CoroutineScope, navController: NavController) {

    var email by remember {
        mutableStateOf("")
    }

    var blankInpt by remember {
        mutableStateOf(false)
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.2f)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                IconButton(
                    onClick = {
                        coroutine.launch {
                            navController.navigate("login")
                        }
                    }, modifier = Modifier.padding(2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(.8f)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(.2f)
                        .padding(start = 2.dp)
                )
                Text(text = "Accounts", fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start=2.dp))
            }
        }
        if (blankInpt) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = CardDefaults.cardColors(Color(0xFFA83232))
                ) {
                    Text(
                        text = "Please fill in all Input fields!",
                        color = Color.White,
                        modifier = Modifier.padding(5.dp, 8.dp)
                    )
                }

            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Forgot Password", fontSize = 35.sp, fontWeight = FontWeight.Bold)
            Text(text = "Enter your registered email below to receive")
            Text(text = "password reset instructions")
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                keyboardOptions = KeyboardOptions(
                    KeyboardCapitalization.None, false, KeyboardType.Email
                ),
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .fillMaxHeight(.08f)
            )
        }


        item {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    coroutine.launch {
                        if (email.isNotEmpty())
                            navController.navigate("verifyAccount")
                        else {
                            blankInpt = true
                            delay(2500)

                            blankInpt = false
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(42.dp)
            ) {
                Text(text = "Proceed")
            }
        }

    }
}

@Composable
fun VerifyAccount(context: Context, coroutine: CoroutineScope, navController: NavController){

    var codeVerify1 by remember { mutableStateOf("") }
    var codeVerify2 by remember { mutableStateOf("") }
    var codeVerify3 by remember { mutableStateOf("") }
    var codeVerify4 by remember { mutableStateOf("") }
    var codeVerify5 by remember { mutableStateOf("") }


    var blankInpt by remember {
        mutableStateOf(false)
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.2f)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                IconButton(
                    onClick = {
                        coroutine.launch {
                            navController.navigate("login")
                        }
                    }, modifier = Modifier.padding(2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(.8f)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(.2f)
                        .padding(start = 2.dp)
                )
                Text(text = "Accounts", fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start=2.dp))
            }
        }
        if (blankInpt) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = CardDefaults.cardColors(Color(0xFFA83232))
                ) {
                    Text(
                        text = "Please fill in all Input fields!",
                        color = Color.White,
                        modifier = Modifier.padding(5.dp, 8.dp)
                    )
                }

            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Verify Email", fontSize = 35.sp, fontWeight = FontWeight.Bold)
            Text(text = "Please fill the below, with the")
            Text(text = "security code that was sent to your email")
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(0.dp, 8.dp)
                    .fillMaxHeight(.2f)
                    .fillMaxWidth(.9f)
            ){
                Spacer(modifier = Modifier.width(5.dp))
                BasicTextField(
                    value = codeVerify1,
                    onValueChange = { codeVerify1 = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .height(42.dp)
                        .width(42.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                BasicTextField(
                    value = codeVerify2,
                    onValueChange = { codeVerify2 = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .height(42.dp)
                        .width(42.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                BasicTextField(
                    value = codeVerify3,
                    onValueChange = { codeVerify3 = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .height(42.dp)
                        .width(42.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                BasicTextField(
                    value = codeVerify4,
                    onValueChange = { codeVerify4 = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .height(42.dp)
                        .width(42.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                BasicTextField(
                    value = codeVerify5,
                    onValueChange = { codeVerify5 = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .height(42.dp)
                        .width(42.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))


            }

        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    coroutine.launch {
                        if (codeVerify1.isNotEmpty() && codeVerify3.isNotEmpty() && codeVerify5.isNotEmpty()) context.startActivity(
                            Intent(context, Dashboard::class.java)
                        )
                        else {
                            blankInpt = true
                            delay(2500)

                            blankInpt = false
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(42.dp)
            ) {
                Text(text = "Confirm")
            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Code not received?")
            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                TextButton(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = AnnotatedString("Resend"),
                        style = TextStyle(color=MaterialTheme.colorScheme.primary)
                    )
                }

                Text(text = " or ")
                TextButton(
                    onClick = {
                        coroutine.launch {
                            navController.navigate("Recovery")
                        }
                    }
                ) {
                    Text(
                        text = AnnotatedString("Change Email"),
                        style = TextStyle(color=MaterialTheme.colorScheme.primary)
                    )
                }

            }

        }

    }
}