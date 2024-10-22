package com.example.examen.ui.iniciarsecion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(email: String, password: String, onLoginResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password).await()
                onLoginResult(true) // Login exitoso
            } catch (e: Exception) {
                onLoginResult(false) // Error en el login
            }
        }
    }
}
