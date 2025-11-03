package com.turingalan.pokemon.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turingalan.pokemon.data.model.Task
import com.turingalan.pokemon.data.repository.TaskRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor (
    private val savedStateHandle: SavedStateHandle,
    private val repository: TaskRepositoryInterface     //repositorio de tareas
): ViewModel() {
    private val _uiState: MutableStateFlow<ListUiState> = MutableStateFlow(ListUiState.Initial) ///Estado de la pagina

    val uiState: StateFlow<ListUiState>     ///estado inmutable visible
        get() = _uiState.asStateFlow()  /// inmutabilizarlo

    init {
        viewModelScope.launch {
            _uiState.value = ListUiState.Loading
            val allTodos = repository.getAll();
            val successResponse = ListUiState.Success(allTodos.asListUiState())
            _uiState.value = successResponse
        }
    }
}

sealed class ListUiState {
    object Initial: ListUiState()
    object Loading: ListUiState()
    data class Success(val todos: List<TaskUiState>): ListUiState()
}

data class TaskUiState(
    val id: Int,
    val title: String
)

/**
 * Transforma un item en un UiState
 *
 *
 * */
fun Task.asTaskUiState(): TaskUiState {
    return TaskUiState(
        id = this.id,
        title = this.title
    )
}

/**
 * Transforma todos los elemento del array en un TaskUiState
 *
 * */
fun List<Task>.asListUiState():List<TaskUiState> = this.map{ it.asTaskUiState() }