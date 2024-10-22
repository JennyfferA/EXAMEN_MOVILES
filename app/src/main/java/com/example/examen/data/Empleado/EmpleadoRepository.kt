import com.example.examen.data.Empleado.AppDatabase
import com.example.examen.data.Empleado.Empleado
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class EmpleadoRepository(private val db: AppDatabase) {

    // Devuelve directamente el Flow<List<Direcion>> desde el DAO
    fun getAllEmpleado(): Flow<List<Empleado>> {
        return db.EmpleadoDao().getAllEmpleado()
            .flowOn(Dispatchers.IO) // Asegurarse de que se ejecute en IO thread
    }

    suspend fun insertEmpleado(direccion: Empleado) {
        db.EmpleadoDao().insertContrato(direccion)
    }

    suspend fun getEmpleadoById(id: Int): Empleado? {
        return db.EmpleadoDao().getEmpleadoById(id)
    }

    suspend fun deleteEmpleadoById(id: Int) {
        db.EmpleadoDao().deleteEmpleadoById(id)
    }
}
