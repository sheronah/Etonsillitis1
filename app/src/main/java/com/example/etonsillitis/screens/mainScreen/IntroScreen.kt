package com.example.etonsillitis.screens.mainScreen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.etonsillitis.Accounts
import com.example.etonsillitis.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun splashScreen(coroutine: CoroutineScope,context:Context) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter= painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Etonsillitis", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(200.dp))
            ElevatedButton(
                onClick = {
                             coroutine.launch {
                                 context.startActivity(Intent(context,Accounts::class.java))
                             }
            },modifier = Modifier.fillMaxWidth(.6f)) {
                Text(text = "Get started")
            }
        }
    }

}