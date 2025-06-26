package com.example.waterreminder.data.repository

import com.example.waterreminder.data.local.IntakeDao
import com.example.waterreminder.data.remote.GoalRemoteDataSource
import com.example.waterreminder.data.toDomain
import com.example.waterreminder.domain.model.WaterIntake
import com.example.waterreminder.domain.repository.WaterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import java.util.*

class WaterRepositoryImpl @Inject constructor(
    private val dao: IntakeDao,
    private val remote: GoalRemoteDataSource
) : WaterRepository {

    override fun todayIntake(): Flow<List<WaterIntake>> =
        dao.todayStream().map { list -> list.map { it.toDomain() } }

    override suspend fun addIntake(amountMl: Int) {
        val entity = WaterIntake(id = UUID.randomUUID().toString(), timestamp = System.currentTimeMillis(), amountMl = amountMl)
        dao.insert(entity.toEntity())
    }

    override suspend fun setGoal(amountMl: Int) {
        remote.setGoal(amountMl)
    }

    override suspend fun getGoal(): Int? = remote.getGoal()
}
