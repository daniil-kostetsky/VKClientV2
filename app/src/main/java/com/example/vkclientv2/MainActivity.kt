package com.example.vkclientv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkclientv2.ui.theme.MainScreen
import com.example.vkclientv2.ui.theme.VkClientV2Theme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<NewsFeedViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkClientV2Theme {
                MainScreen()
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Test() {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = { Text(text = "TODO") },
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) }
                )
                NavigationDrawerItem(
                    label = { Text(text = "TODO") },
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) }
                )
                NavigationDrawerItem(
                    label = { Text(text = "TODO") },
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Top title") },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
                        }
                    }

                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) })
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) })
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) })
                }
            }
        ) {
            Text(
                modifier = Modifier.padding(it),
                text = "Scaffold content"
            )
        }
    }

}