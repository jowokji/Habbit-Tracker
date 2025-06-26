package com.example.waterreminder.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.waterreminder.presentation.viewmodel.WaterViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DashboardScreen(vm: WaterViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        // Progress circle
        CircularProgressIndicator(progress = state.progress, strokeWidth = 8.dp, modifier = Modifier.size(160.dp))
        Text("${state.totalDrunk} / ${state.goal} ml", style = MaterialTheme.typography.titleMedium)
        Text("Remaining: ${state.remaining} ml")

        Spacer(Modifier.height(24.dp))

        // Quick add buttons
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(200, 300, 500).forEach { amount ->
                Button(onClick = { vm.drink(amount) }) {
                    Text("+${amount}ml")
                }
            }
        }
    }
}
