package com.example.waterreminder.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waterreminder.data.local.SettingsDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val ds: SettingsDataStore
): ViewModel() {
    val isDark = ds.themeFlow.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "light")
        .map { it == "dark" }

    val unit = ds.unitFlow.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "ml")

    fun switchTheme() = viewModelScope.launch {
        val tgt = if (isDark.value) "light" else "dark"
        ds.setTheme(tgt)
    }
    fun switchUnit() = viewModelScope.launch {
        val tgt = if (unit.value == "ml") "l" else "ml"
        ds.setUnit(tgt)
    }
}
