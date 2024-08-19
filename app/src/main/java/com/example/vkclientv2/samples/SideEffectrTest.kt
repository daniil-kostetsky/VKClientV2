package com.example.vkclientv2.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

var globalCounter = 1123

@Composable
fun DoSmthng() {
    SideEffect {
        globalCounter++
//        println("counter: $globalCounter")
    }
    println("counter: $globalCounter")


    Text("$globalCounter")
}
