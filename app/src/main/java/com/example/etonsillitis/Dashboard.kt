package com.example.etonsillitis

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.etonsillitis.screens.Dashboard.questionOne
import com.example.etonsillitis.screens.Dashboard.questionThree
import com.example.etonsillitis.screens.Dashboard.questionTwo
import com.example.etonsillitis.screens.Dashboard.resultScreen
import com.example.etonsillitis.screens.Dashboard.uploadPicture
import com.example.etonsillitis.ui.theme.EtonsillitisTheme

class Dashboard : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtonsillitisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val coroutine = rememberCoroutineScope()
                    val context = LocalContext.current
                    val navController = rememberNavController()
                    val myRoutes = Myquestions()
                    val drawerstate = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val name = this.intent.getStringExtra("screen")


                    ModalNavigationDrawer(
                        drawerState = drawerstate,
                        drawerContent = {
                            ModalDrawerSheet(modifier = Modifier.fillMaxWidth(.85f)) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                        .background(MaterialTheme.colorScheme.primary),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = null,
                                        modifier = Modifier.size(100.dp)

                                    )
                                    Column {
                                        Text(
                                            text = "Sheronah",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 22.sp
                                        )
                                        Text(text = "Sheronah@gmail.com")
                                    }


                                }
                                NavigationDrawerItem(
                                    label = { Text(text = "Profile") },
                                    selected = false,
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.AccountCircle,
                                            contentDescription = null
                                        )
                                    },
                                    onClick = { /*TODO*/ })
                                NavigationDrawerItem(
                                    label = { Text(text = "notifications") },
                                    selected = false,
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.Notifications,
                                            contentDescription = null
                                        )
                                    },
                                    onClick = { /*TODO*/ })
                                NavigationDrawerItem(
                                    label = { Text(text = "security") },
                                    selected = false,
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.Lock,
                                            contentDescription = null
                                        )
                                    },
                                    onClick = { /*TODO*/ })
                                NavigationDrawerItem(
                                    label = { Text(text = "Logout") },
                                    selected = false,
                                    icon = {
                                        Icon(
                                            imageVector = Icons.Default.ExitToApp,
                                            contentDescription = null
                                        )
                                    },
                                    onClick = { /*TODO*/ })

                            }
                        })

                    {


                        NavHost(
                            modifier = Modifier
                                .fillMaxSize(),
                            navController = navController,
                            startDestination =myRoutes.pic
                        ) {
                            composable(myRoutes.Q1) {
                                questionOne(
                                    coroutineScope = coroutine,
                                    navController = navController,drawerstate
                                )
                            }
                            composable(myRoutes.Q2) {
                                questionTwo(
                                    coroutineScope = coroutine,
                                    navController = navController,drawerstate
                                )
                            }
                            composable(myRoutes.Q3) {
                                questionThree(
                                    coroutineScope = coroutine,
                                    navController = navController,drawerstate
                                )
                            }
                            composable(myRoutes.results) { resultScreen(coroutine, navController,drawerstate) }
                            composable(myRoutes.map) {}
                            composable(myRoutes.settings) {}
                            composable(myRoutes.pic) {
                                uploadPicture(
                                    coroutine,
                                    navController,drawerstate
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Myquestions(
    val results: String = "Results",
    val map: String = "map",
    val settings: String = "Settings",
    val pic: String = "pci",
    val Q1: String = "Q1",
    val Q2: String = "Q2",
    val Q3: String = "Q3",

    )
