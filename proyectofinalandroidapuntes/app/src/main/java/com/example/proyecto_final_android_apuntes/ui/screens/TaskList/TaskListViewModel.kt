import com.example.proyecto_final_android_apuntes.data.model.Task
import javax.inject.Inject

sealed class TodoUiState{
    object Loading: TodoUiState()
    data class Success(val tasks: List<Task>): TodoUiState()
    data class Error(val message: String): TodoUiState()
}

class TaskListViewModel @Inject constructor (

){

}