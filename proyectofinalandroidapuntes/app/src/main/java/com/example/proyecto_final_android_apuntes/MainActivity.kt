package com.example.proyecto_final_android_apuntes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import com.example.proyecto_final_android_apuntes.ui.navigation.NavGraph
import com.example.proyecto_final_android_apuntes.ui.theme.ProyectofinalandroidapuntesTheme

/**
 * @AndroidEntryPoint: Hilt inyecta dependencias en esta Activity
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectofinalandroidapuntesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph();
                }
            }
        }
    }
}