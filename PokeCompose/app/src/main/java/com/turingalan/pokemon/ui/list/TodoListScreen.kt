package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoListScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoListViewModel = hiltViewModel(),
    onNavigateToDetail: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    when(uiState) {
        is ListUiState.Initial -> {
            TODO()
        }
        is ListUiState.Loading -> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        }
        is ListUiState.Success -> {
            LazyColumn(
                modifier = modifier
            ) {
                items((uiState as ListUiState.Success).todos, key = { it.id }) { todo ->
                    RenderTask(
                        id = todo.id,
                        title = todo.title,
                        onClick = onNavigateToDetail,
                    )
                }
            }
        }
    }
}

@Composable
fun RenderTask(
    id: Int,
    title: String,
    onClick: (Int) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(true, onClick={ onClick(id) }),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(title)
    }
}