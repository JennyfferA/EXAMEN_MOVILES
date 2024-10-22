package com.example.inventory.ui




import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory



import com.example.examen.ExameApplication
import com.example.examen.ui.Empleado.EmpleadoDetailViewModel

import com.example.examen.ui.Empleado.EmpleadoViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            val appContainer = inventoryApplication().container
            // Inicializa el ViewModel direcionViewModel con el direcionRepository
            EmpleadoViewModel(appContainer.empleadoRepository)
        }
        initializer {
            val appContainer = inventoryApplication().container
            // Inicializa el ViewModel direcionViewModel con el direcionRepository
            EmpleadoDetailViewModel(appContainer.empleadoRepository)
        }
    }
}


/**
 * Función de extensión para consultar el objeto [Application] y devolver una instancia de
 * [DiarioApplication].
 */
fun CreationExtras.inventoryApplication(): ExameApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ExameApplication)

