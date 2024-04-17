package com.example.etonsillitis.screens.Dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.etonsillitis.Myquestions
import com.example.etonsillitis.R
import com.example.etonsillitis.modelWork.CNNviewModel
import com.example.etonsillitis.modelWork.Predictions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable

fun uploadPicture(
    coroutineScope: CoroutineScope,
    navController: NavController,
    drawerstate: DrawerState
) {
    val imageState = remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    val viewModel = CNNviewModel(context)
    var predictionResult by remember { mutableStateOf(Predictions()) }


    val ourCamera =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let {
                val currentDateTime = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                val formattedDateTime = currentDateTime.format(formatter)

                // Save the image to your device
                val imageName = "$formattedDateTime _tonsilSample.png"
                val imageFile =
                    File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), imageName)

                val output = FileOutputStream(imageFile)
                it.compress(Bitmap.CompressFormat.PNG, 100, output)
                output.close()

                imageState.value = it

                // Get the image path and pass it into the classifyImage() function
                val imagePath = imageFile.absolutePath
                Toast.makeText(context, imagePath, Toast.LENGTH_SHORT).show()
                // Log.d(TAG, "uploadPicture: "+imagePath);
                viewModel.classifyImage(imagePath)
                predictionResult = viewModel.predictionResult.value!!

                // Upload the image to your server
                //uploadImageToServer(imageFile, imageName, coroutineScope)
            }
        }


    val selectImage =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val selectedImage: Uri? = result.data?.data
                try {
                    val bitmap: Bitmap = BitmapFactory.decodeStream(
                        context.contentResolver.openInputStream(selectedImage!!)
                    )
                    imageState.value = bitmap

                    val currentDateTime = LocalDateTime.now()
                    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                    val formattedDateTime = currentDateTime.format(formatter)

                    // Save the bitmap to a file
                    val imageName = "$formattedDateTime _tonsilSample.png"
                    val file = File(context.cacheDir, imageName)

                    val imageOutput = FileOutputStream(file)
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, imageOutput)
                    imageOutput.close()

                    // Get the image path and pass it into the classifyImage() function
                    val imagePath = file.absolutePath
                    viewModel.classifyImage(imagePath)

                    predictionResult = viewModel.predictionResult.value!!

                    // Upload the image to your server
                    //uploadImageToServer(file, imageName, coroutineScope)

                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }
        }

    LazyColumn(
        modifier = Modifier
        .fillMaxSize()
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.2f)
                ) {
                    Text(
                        text = "Image Selection",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))


                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth(.85f)
                        .height(200.dp)
                ) {
                    imageState.value?.asImageBitmap()?.let {
                        Image(
                            bitmap = it,
                            contentDescription = "Selected Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CutCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(.85f)
                        .fillMaxHeight(.23f)
                        .padding(vertical = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            ourCamera.launch()
                        }, modifier = Modifier
                            .fillMaxWidth(.5f)
                            .padding(2.dp)
                            .fillMaxHeight()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                            contentDescription = null
                        )
                        Text(text = "Take Picture")
                    }
                    Button(
                        onClick = {

                            val intent =
                                Intent(
                                    Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                                )
                            selectImage.launch(intent)

                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .fillMaxHeight()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_insert_photo_24),
                            contentDescription = null
                        )
                        Text(text = "Select Image")
                    }
                }

                ElevatedCard {
                    Box(contentAlignment = Alignment.Center) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Prediction Results",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Viral: ",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "${predictionResult.viral}")
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Bacterial: ",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "${predictionResult.bacterial}")
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Normal: ",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "${predictionResult.normal}")
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Unknown: ",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "${predictionResult.unknown}")
                            }


                        }
                    }
                }

                ElevatedButton(onClick = {
                    coroutineScope.launch {
                        navController.navigate(Myquestions().results)

                    }
                }) {
                    Text(text = "DIAGNOSE", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                }

            }
        }
    }
}

fun uploadImageToServer(file: File, imageName: String, coroutine: CoroutineScope) {
    coroutine.launch {
        // Upload the file to the server
        val client = OkHttpClient()
        val requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("file", imageName, file.asRequestBody("image/png".toMediaTypeOrNull()))
            .build()

        val request = okhttp3.Request.Builder()
            .url("http://192.168.137.150:8000/getImage/")
            .post(requestBody)
            .build()

        client.newCall(request).execute()
    }
}
