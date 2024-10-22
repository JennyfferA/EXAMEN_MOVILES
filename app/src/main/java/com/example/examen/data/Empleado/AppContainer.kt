package com.example.examen.data.Empleado

import EmpleadoRepository
import android.content.Context


/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val empleadoRepository: EmpleadoRepository

}

/**
 * [AppContainer] implementation that provides instances of repositories for the application.
 */
class DefaultAppContainer(context: Context) : AppContainer {
    // Inicialización de la base de datos
    private val database = AppDatabase.getDatabase(context)

    // Implementación de direcionRepository
    override val empleadoRepository: EmpleadoRepository by lazy {
        EmpleadoRepository(database)
    }

    // Implementación de estudiantesRepository

}
