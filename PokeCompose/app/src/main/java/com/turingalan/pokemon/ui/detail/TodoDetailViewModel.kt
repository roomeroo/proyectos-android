package com.turingalan.pokemon.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.turingalan.pokemon.data.model.Task
import com.turingalan.pokemon.data.repository.TaskRepositoryInterface
import com.turingalan.pokemon.ui.Destinations
import com.turingalan.pokemon.ui.list.TaskUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor (
    private val savedStateHandle: SavedStateHandle,
    private val repository: TaskRepositoryInterface
): ViewModel() {
    private val _uiState: MutableStateFlow<DetailUiSate> = MutableStateFlow(DetailUiSate())
    val uiState: StateFlow<DetailUiSate>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val route = savedStateHandle.toRoute<Destinations.Details>()
            val todo = repository.getById(route.id)
            //Si existe el todo, se pone como estado
            todo?.let {
                _uiState.value = todo.toDetailUiState()
            }
        }
    }

    suspend fun completarTodo(){
        repository.completeTask(this._uiState.value.id)
    }
}

fun Task.toDetailUiState(): DetailUiSate {
    return DetailUiSate(
        id = this.id,
        title = this.title,
        description = this.description,
        completed = this.completed
    )
}

data class DetailUiSate(
    val id:Int = -1,
    val title:String = "",
    val description: String = "",
    val completed: Boolean = false
)

sealed class DetailUiState {
    object Initial: DetailUiState()
    object Loading: DetailUiState()
    data class Success(val todo: DetailUiState): DetailUiState()
}