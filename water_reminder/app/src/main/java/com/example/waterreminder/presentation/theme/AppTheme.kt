package com.example.waterreminder.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.waterreminder.presentation.viewmodel.SettingsViewModel

private val Light = lightColorScheme()
private val Dark = darkColorScheme()

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val vm: SettingsViewModel = hiltViewModel()
    val dark by vm.isDark.collectAsState(false)
    MaterialTheme(
        colorScheme = if (dark) Dark else Light,
        typography = Typography,
        content = content
    )
}
