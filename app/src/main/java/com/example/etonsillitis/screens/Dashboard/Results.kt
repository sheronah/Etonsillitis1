package com.example.etonsillitis.screens.Dashboard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.etonsillitis.modelWork.CNNviewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun resultScreen(
    coroutine: CoroutineScope,
    navController: NavHostController,
    drawerstate: DrawerState
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        SheetState(
            skipPartiallyExpanded = true,
            SheetValue.Hidden
        )
    )

    BottomSheetScaffold(
        sheetContent = { ourMap() },
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,

    ) {


        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.15f)
            ) {
                IconButton(onClick = {
                    coroutine.launch {
                        drawerstate.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                item {

//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth(.85f)
                            .height(200.dp)
                    ) {
                        //diagnosed image

//                }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(.85f)
                    ) {


                        Text(
                            text = "Results",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }
                }
                item {

                    Column(
                        modifier = Modifier.fillMaxWidth(.85f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically

                        ) {

                            Text(text = "Class:", fontSize = 22.sp, color = Color.Gray)
                            Text(text = "VAseee", fontSize = 22.sp)
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(text = "Confidence level:", fontSize = 22.sp, color = Color.Gray)
                            Text(text = "60.543%", fontSize = 22.sp)
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(.85f)

                    ) {


                        Text(
                            text = "First Aid",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(.85f)

                    ) {


                        Text(
                            text = "Hydrate a lot", fontSize = 20.sp,

                            )
                        Text(
                            text = "Drink warm water", fontSize = 20.sp,

                            )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    ElevatedCard(
                        onClick = {
                                  coroutine.launch {
                                      scaffoldState.bottomSheetState.expand()
                                  }
                        }, modifier = Modifier

                            .fillMaxWidth(.85f)
                            .height(50.dp)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "View nearby hospitals")
                            Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                        }
                    }

                }
            }
        }


    }


}

@Composable
fun ourMap() {
    val Mbarara = LatLng(-0.616914, 30.656704)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(Mbarara, 16f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = Mbarara),
            title = "Mbarara",
            snippet = "Marker in Mbarara"
        )
    }
}

