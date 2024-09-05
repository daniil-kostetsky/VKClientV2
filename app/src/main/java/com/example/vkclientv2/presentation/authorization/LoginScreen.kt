package com.example.vkclientv2.presentation.authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkclientv2.R
import com.example.vkclientv2.presentation.ViewModelFactory
import com.example.vkclientv2.ui.theme.DarkBlue

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.wrapContentHeight(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.vk_logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = { onLoginClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(id = R.string.button_login),
                    fontSize = 22.sp
                )
            }
        }
    }
}