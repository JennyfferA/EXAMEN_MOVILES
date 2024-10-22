package com.example.examen.ui.iniciarsecion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen(onNavigateToLogin: () -> Unit) {
    val authhViewModel: AuthhViewModel = viewModel()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isRegistrationSuccessful by remember { mutableStateOf<Boolean?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Registro", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    if (email.isEmpty()) Text("Correo Electrónico")
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    if (password.isEmpty()) Text("Contraseña")
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            authhViewModel.register(email, password) { success ->
                isRegistrationSuccessful = success
                if (success) {
                    // Redirigir a la pantalla de inicio o login
                    onNavigateToLogin()
                } else {
                    // Manejar error (por ejemplo, mostrar un mensaje)
                }
            }
        }) {
            Text("Registrarse")
        }

        // Mostrar un mensaje en caso de error
        isRegistrationSuccessful?.let { success ->
            if (!success) {
                Text("Error al registrar, intenta de nuevo", color = Color.Red)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onNavigateToLogin) {
            Text("¿Ya tienes cuenta? Inicia Sesión")
        }
    }
}




