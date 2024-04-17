package com.example.etonsillitis.screens.Dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.etonsillitis.Myquestions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


val roots = Myquestions()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun questionOne(
    coroutineScope: CoroutineScope,
    navController: NavController,
    drawerstate: DrawerState
) {


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f)
            ) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        drawerstate.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }
        }
        item {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4633B9))


            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {


                    Column {
                        Text(
                            text = "How long has",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                        Text(
                            text = "How long has",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                        Text(
                            text = "How long has",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedButton(onClick = { coroutineScope.launch {
                    navController.navigate(Myquestions().pic)
                } }, modifier = Modifier.padding(
                    top = 8.dp,
                    end = 20.dp,
                    bottom = 8.dp,
                    start = 8.dp
                )) {
                    Text(text="Skip", fontSize = 21.sp, fontWeight = FontWeight.Bold)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.Q2)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.Q2)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.Q2)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun questionTwo(
    coroutineScope: CoroutineScope,
    navController: NavController,
    drawerstate: DrawerState
) {


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f)
            ) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        drawerstate.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }
        }
        item {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4633B9))

            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {


                    Column {
                        Text(
                            text = "How long has",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                        Text(
                            text = "How long has",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                        Text(
                            text = "How long has",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedButton(onClick = { coroutineScope.launch {
                    navController.navigate(Myquestions().pic)
                } }, modifier = Modifier.padding(
                    top = 8.dp,
                    end = 20.dp,
                    bottom = 8.dp,
                    start = 8.dp
                )) {
                    Text(text="Skip", fontSize = 21.sp, fontWeight = FontWeight.Bold)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.Q3)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.Q3)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.Q3)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun questionThree(
    coroutineScope: CoroutineScope,
    navController: NavController,
    drawerstate: DrawerState
) {


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f)
            ) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        drawerstate.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }
        }
        item {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4633B9))

            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {


                    Column {
                        Text(
                            text = "How long has",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                        Text(
                            text = "How long has",
                            fontSize = 32.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                        Text(
                            text = "How long has",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.padding(8.dp, 2.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedButton(onClick = { coroutineScope.launch {
                    navController.navigate(Myquestions().pic)
                } }, modifier = Modifier.padding(
                    top = 8.dp,
                    end = 20.dp,
                    bottom = 8.dp,
                    start = 8.dp
                )) {
                    Text(text="Skip", fontSize = 21.sp, fontWeight = FontWeight.Bold)

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.pic)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.pic)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
                ElevatedCard(
                    onClick = {
                        coroutineScope.launch {
                            navController.navigate(roots.pic)
                        }
                    }, modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.9f)
                        .height(50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Btwn 2and 3 days")
                    }
                }
            }
        }
    }

}


