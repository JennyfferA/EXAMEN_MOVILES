package com.example.examen.ui.Navegacion


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.ui.Empleado.EmpleadoDetailScreen
import com.example.examen.ui.Empleado.EmpleadoListScreen

import com.example.examen.ui.Navegación.Routes

import com.example.examen.ui.iniciarsecion.LoginScreen
import com.example.examen.ui.iniciarsecion.RegisterScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login // Inicia en la pantalla de login
    ) {
        composable(Routes.Login) {
            LoginScreen(
                navController = navController,
                onLoginClick = { email, password ->
                    navController.navigate(Routes.Direcciones) // Navega a la pantalla de detalle
                },
                onNavigateToRegister = {
                    navController.navigate(Routes.Register)
                }
            )
        }

        composable(Routes.Register) {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.Login)
                }
            )
        }

        composable(Routes.Direcciones) {
            EmpleadoListScreen(onEmpleadoClick  = { direccionId ->
                navController.navigate("direccion/$direccionId") // Navegar a los detalles de la dirección
            })
        }
        composable(Routes.DireccionDetail) { backStackEntry ->
            val EmpleadoId = backStackEntry.arguments?.getString("direccionId")?.toInt() ?: 0
            EmpleadoDetailScreen(
                empleadoId  = EmpleadoId,
                onDeleteSuccess = {
                    navController.popBackStack() // Regresar a la lista al eliminar
                }
            )
        }
    }
}
