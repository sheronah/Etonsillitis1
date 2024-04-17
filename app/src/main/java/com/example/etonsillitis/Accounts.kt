package com.example.etonsillitis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.etonsillitis.screens.Accounts.Login
import com.example.etonsillitis.screens.Accounts.Recovery
import com.example.etonsillitis.screens.Accounts.Register
import com.example.etonsillitis.screens.Accounts.VerifyAccount
import com.example.etonsillitis.ui.theme.EtonsillitisTheme


class Accounts : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtonsillitisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    val coroutine = rememberCoroutineScope()
                    val context = LocalContext.current
                    val moveAround= rememberNavController()
                    NavHost(navController = moveAround, startDestination = "login")
                    {
                        composable("login"){
                            Login(context = context, coroutine = coroutine, navController =moveAround )
                        }
                        composable("Register"){
                            Register(context = context, coroutine = coroutine, navController =moveAround )
                        }
                        composable("Recovery"){
                            Recovery(context = context, coroutine = coroutine, navController =moveAround )
                        }
                        composable("verifyAccount"){
                            VerifyAccount(context = context, coroutine = coroutine, navController =moveAround )
                        }
                    }
                }
            }
        }
    }
}

