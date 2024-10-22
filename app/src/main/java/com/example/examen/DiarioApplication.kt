package com.example.examen

import android.app.Application
import com.example.examen.data.Empleado.AppContainer
import com.example.examen.data.Empleado.DefaultAppContainer
import com.google.firebase.FirebaseApp

class ExameApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        // Inicializar Firebase
        FirebaseApp.initializeApp(this)

        // Inicializar el contenedor
        container = DefaultAppContainer(this)
    }
}

