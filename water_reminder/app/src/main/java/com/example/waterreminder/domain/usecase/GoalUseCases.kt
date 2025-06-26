package com.example.waterreminder.domain.usecase

import com.example.waterreminder.domain.repository.WaterRepository
import javax.inject.Inject

class SetGoalUseCase @Inject constructor(private val repo: WaterRepository) {
    suspend operator fun invoke(goalMl: Int) = repo.setGoal(goalMl)
}
class GetGoalUseCase @Inject constructor(private val repo: WaterRepository) {
    suspend operator fun invoke() = repo.getGoal()
}
