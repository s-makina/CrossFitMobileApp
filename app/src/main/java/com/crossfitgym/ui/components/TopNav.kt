package com.crossfitgym.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.crossfitgym.R
import com.crossfitgym.ui.navigarion.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNav() {
    val expanded = remember { mutableStateOf(false) }

    TopAppBar(modifier = Modifier.fillMaxWidth(), title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.FitnessCenter,
                contentDescription = "Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = "CrossFit Gym", style = MaterialTheme.typography.titleMedium)
        }

    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }

        IconButton(onClick = { expanded.value = true }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)

            MenuDropDown(expanded = expanded, onClick = {
                if (it == "logout") {
//                    settingsViewModel.logout(context)

//                            navController.navigate(Screen.LoginPage.route) {
//                                popUpTo(Screen.LoginPage.route)
//                            }
                } else {
//                    navController.navigate(it) {
//                        launchSingleTop = true
//                    }
                }
            })
        }
    })
}

@Composable
fun MenuDropDown(expanded: MutableState<Boolean>, onClick: (String) -> Unit = {}) {
    DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {

        DropdownMenuItem(
            text = { Text("Admin Home") },
            onClick = {
                expanded.value = false
                onClick(Screen.SettingsPage.route)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AdminPanelSettings,
                    contentDescription = ""
                )
            })

        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = {
                expanded.value = false
                onClick(Screen.SettingsPage.route)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = ""
                )
            })

        DropdownMenuItem(
            text = { Text("Logout") },
            onClick = {
                expanded.value = false
                onClick("logout")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = ""
                )
            })
    }
}
