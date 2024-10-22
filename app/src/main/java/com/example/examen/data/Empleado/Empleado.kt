package com.example.examen.data.Empleado

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Empleado")
data class Empleado(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val trabajo: String,
    val detalle: String,
    val imagenUri: Int,
    val sueldo: Double
)

