package com.example.examen.ui.Empleado

import EmpleadoRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.Empleado.Empleado
import com.example.inventory.R
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EmpleadoViewModel(
    private val empleadoRepository: EmpleadoRepository
) : ViewModel() {

    // Cambiar contratos a empleados para reflejar el cambio
    val empleados: StateFlow<List<Empleado>> = empleadoRepository.getAllEmpleado()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )

    init {
        // Llamar a la función para insertar empleados al inicializar el ViewModel
        viewModelScope.launch {
            insertInitialEmpleados()
        }
    }

    private suspend fun insertInitialEmpleados() {
        // Comprobar si ya hay empleados antes de insertar
        if (empleados.value.isEmpty()) {
            val initialEmpleados = listOf(
                Empleado(trabajo = "Asistente Administrativo", detalle = "Gestión de documentos y soporte administrativo", imagenUri = R.drawable.culinary, sueldo = 900.0),
                Empleado(trabajo = "Desarrollador Web", detalle = "Creación y mantenimiento de sitios web", imagenUri = R.drawable.design, sueldo = 1800.0),
                Empleado(trabajo = "Analista de Datos", detalle = "Análisis y visualización de datos para la toma de decisiones", imagenUri = R.drawable.drawing, sueldo = 1600.0),
                Empleado(trabajo = "Marketing Digital", detalle = "Estrategias de marketing en redes sociales", imagenUri = R.drawable.ecology, sueldo = 1400.0),
                Empleado(trabajo = "Gerente de Proyecto", detalle = "Supervisión y gestión de proyectos", imagenUri = R.drawable.engineering, sueldo = 2500.0)
            )

            // Insertar los empleados iniciales en la base de datos
            initialEmpleados.forEach { empleado ->
                empleadoRepository.insertEmpleado(empleado)
            }
        }
    }
}
