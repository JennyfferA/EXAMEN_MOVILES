package com.example.examen.data.Empleado

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Empleado::class], version = 2) // Incrementa la versión
abstract class AppDatabase : RoomDatabase() {

    abstract fun EmpleadoDao(): EmpleadoDao // Cambiar a direccionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Esto permite la migración destructiva
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
