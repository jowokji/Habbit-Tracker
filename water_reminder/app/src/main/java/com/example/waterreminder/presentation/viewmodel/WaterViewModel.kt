package com.example.waterreminder.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waterreminder.domain.usecase.AddIntakeUseCase
import com.example.waterreminder.domain.usecase.GetGoalUseCase
import com.example.waterreminder.domain.usecase.ObserveIntakeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardState(
    val totalDrunk: Int = 0,
    val goal: Int = 2000
) {
    val remaining get() = (goal - totalDrunk).coerceAtLeast(0)
    val progress get() = totalDrunk.toFloat() / goal
}

@HiltViewModel
class WaterViewModel @Inject constructor(
    observe: ObserveIntakeUseCase,
    private val addIntake: AddIntakeUseCase,
    private val getGoal: GetGoalUseCase
) : ViewModel() {

    private val _goal = MutableStateFlow(2000)
    val state: StateFlow<DashboardState> = combine(observe(), _goal) { intake, goal ->
        DashboardState(intake.sumOf { it.amountMl }, goal)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), DashboardState())

    init {
        viewModelScope.launch {
            getGoal()?.let { _goal.value = it }
        }
    }

    fun drink(amountMl: Int) = viewModelScope.launch {
        addIntake(amountMl)
    }
}
