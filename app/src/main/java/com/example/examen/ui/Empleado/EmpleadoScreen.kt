package com.example.examen.ui.Empleado

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventory.ui.AppViewModelProvider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import com.example.examen.ui.theme.Purple40
import com.example.examen.ui.theme.PurpleGrey40

@Composable
fun EmpleadoListScreen(
    onEmpleadoClick: (Int) -> Unit, // Callback para navegar a los detalles del empleado
    viewModel: EmpleadoViewModel = viewModel(factory = AppViewModelProvider.Factory) // Obtención del ViewModel
) {
    val empleados = viewModel.empleados.collectAsState(initial = emptyList()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Purple40),
        horizontalAlignment = Alignment.CenterHorizontally // Centrar el contenido horizontalmente
    ) {
        Text(
            text = "Empleados",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp),
            color = PurpleGrey40
        )

        // Lista de empleados
        empleados.forEach { empleado ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onEmpleadoClick(empleado.id) } // Navegar al hacer clic
                    .border(1.dp, color = PurpleGrey40) // Borde entre elementos
                    .padding(16.dp) // Padding interno para el texto
            ) {
                Text(
                    text = empleado.trabajo,
                    style = MaterialTheme.typography.bodyLarge,
                    color = PurpleGrey40
                )
            }
        }
    }
}
