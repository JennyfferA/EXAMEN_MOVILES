package com.example.examen.ui.iniciarsecion

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthhViewModel : ViewModel() {

    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        // Aquí haces la validación del correo y la contraseña
        if (email.isNotEmpty() && password.isNotEmpty()) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registro exitoso
                        onResult(true)
                    } else {
                        // Registro fallido, maneja el error
                        onResult(false)
                    }
                }
        } else {
            // Validación fallida
            onResult(false)
        }
    }
}

