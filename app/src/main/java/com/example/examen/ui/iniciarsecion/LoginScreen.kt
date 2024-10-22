package com.example.examen.ui.iniciarsecion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.examen.ui.Navegación.Routes

@Composable
fun LoginScreen(
    navController: NavController,
    onLoginClick: (String, String) -> Unit,
    onNavigateToRegister: () -> Unit
) {
    val authViewModel: AuthViewModel = viewModel()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoginSuccessful by remember { mutableStateOf<Boolean?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Inicio de Sesión", style = MaterialTheme.typography.headlineMedium)

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
            authViewModel.login(email, password) { success ->
                isLoginSuccessful = success
                if (success) {
                    onLoginClick(email, password) // Llama a la función de navegación
                } else {
                    // Manejar error (por ejemplo, mostrar un mensaje)
                }
            }
        }) {
            Text("Iniciar Sesión")
        }

        // Mostrar un mensaje en caso de error
        isLoginSuccessful?.let { success ->
            if (!success) {
                Text("Error de inicio de sesión. Verifica tus credenciales.", color = Color.Red)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onNavigateToRegister) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}
