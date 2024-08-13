package com.example.vkclientv2.ui.theme

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ActivityResultTest() {
    var imageUri by remember {
        mutableStateOf<Uri?>(Uri.EMPTY)
    }
    val a by lazy {

    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        imageUri = it
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier.weight(1f),
            model = imageUri, contentDescription = null
        )
        Button(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            onClick = { launcher.launch("image/*") }) {
            Text(text = "Load")
        }
    }
}