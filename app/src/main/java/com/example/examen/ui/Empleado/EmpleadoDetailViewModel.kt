package com.example.examen.ui.Empleado

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.Empleado.Empleado
import EmpleadoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmpleadoDetailViewModel(
    private val empleadoRepository: EmpleadoRepository
) : ViewModel() {

    private val _empleado = MutableStateFlow<Empleado?>(null)
    val empleado: StateFlow<Empleado?> = _empleado

    fun loadEmpleado(id: Int) {
        viewModelScope.launch {
            _empleado.value = empleadoRepository.getEmpleadoById(id)
        }
    }

    fun deleteEmpleado(id: Int) {
        viewModelScope.launch {
            empleadoRepository.deleteEmpleadoById(id)
        }
    }
}
