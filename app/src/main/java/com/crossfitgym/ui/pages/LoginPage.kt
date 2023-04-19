package com.crossfitgym.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import com.crossfitgym.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.crossfitgym.ui.components.ParticleBackground
import com.crossfitgym.ui.navigarion.Screen


@Composable
fun LoginScreen(navController: NavHostController) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Blue),
        start = Offset.Zero,
        end = Offset.Infinite
    )

    var isPasswordVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ParticleBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.FitnessCenter,
                contentDescription = "Gym Logo",
                modifier = Modifier.size(128.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Log in to your account",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = CircleShape,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = null,
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = CircleShape,
                trailingIcon = {
                    IconButton(onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }) {
                        val icon =
                            if (isPasswordVisible) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility
                        Icon(
                            imageVector = icon,
                            contentDescription = "Password Toggle"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { navController.navigate(Screen.Home.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Log in")
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                onClick = { /* Handle forgot password button click */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Forgot password?")
            }
            Spacer(modifier = Modifier.height(16.dp))
            GoogleLoginButton(
                onClick = { /* Handle Google login button click */ }
            )
        }
    }
}

@Composable
fun GoogleLoginButton(onClick: () -> Unit) {
    val colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    )

    OutlinedButton(
        onClick = onClick,
        colors = colors,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Log in with Google")
        }
    }
}



