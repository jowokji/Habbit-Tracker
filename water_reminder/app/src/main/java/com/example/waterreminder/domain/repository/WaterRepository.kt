package com.example.waterreminder.domain.repository

import com.example.waterreminder.domain.model.WaterIntake
import kotlinx.coroutines.flow.Flow

interface WaterRepository {
    fun todayIntake(): Flow<List<WaterIntake>>
    suspend fun addIntake(amountMl: Int)
    suspend fun setGoal(amountMl: Int)
    suspend fun getGoal(): Int?
}
