package com.turingalan.pokemon.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import org.w3c.dom.Text

@Composable
fun TodoDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoDetailViewModel = hiltViewModel(),
    onCancel: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    when(uiState){
        is DetailUiState.Initial -> {
            //TODO
        }

        is DetailUiState.Loading -> {
            //TODO
        }

        is DetailUiState.Success -> {

        }
    }
}

@Composable
fun renderDetail(
    modifier: Modifier = Modifier,
    uiState: DetailUiState,
){
    Column(
        modifier = modifier,
    ) {
        OutlinedTextField()
    }
}