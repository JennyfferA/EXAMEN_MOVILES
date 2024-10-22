package com.example.examen.data.Empleado

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface EmpleadoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContrato(direccion: Empleado)

    @Query("SELECT * FROM Empleado")
    fun getAllEmpleado(): Flow<List<Empleado>>

    @Query("SELECT * FROM Empleado WHERE id = :id")
    suspend fun getEmpleadoById(id: Int): Empleado?

    @Query("DELETE FROM Empleado WHERE id = :id")
    suspend fun deleteEmpleadoById(id: Int)
}
