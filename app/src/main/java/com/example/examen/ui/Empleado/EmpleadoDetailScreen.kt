package com.example.examen.ui.Empleado

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventory.ui.AppViewModelProvider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState


@Composable
fun EmpleadoDetailScreen(
    empleadoId: Int,
    onDeleteSuccess: () -> Unit, // Callback para manejar la eliminación exitosa
    viewModel: EmpleadoDetailViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val empleado = viewModel.empleado.collectAsState().value

    LaunchedEffect(empleadoId) {
        viewModel.loadEmpleado(empleadoId)
    }

    empleado?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cargar y mostrar la imagen desde los recursos
            val imageResId = it.imagenUri // Usar el identificador como recurso
            Image(
                painter = painterResource(id = imageResId), // Cargar la imagen usando el identificador
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp) // Cambia el tamaño según tus necesidades
                    .padding(bottom = 16.dp)
            )

            // Mostrar los demás detalles
            Text(text = it.trabajo, style = MaterialTheme.typography.titleLarge)
            Text(text = it.detalle, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Numeración: ${it.sueldo}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.deleteEmpleado(empleadoId)
                    onDeleteSuccess()
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Eliminar Empleado")
            }
        }
    }
}
