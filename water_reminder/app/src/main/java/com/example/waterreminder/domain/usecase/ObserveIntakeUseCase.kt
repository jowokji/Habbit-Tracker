package com.example.waterreminder.domain.usecase

import com.example.waterreminder.domain.repository.WaterRepository
import javax.inject.Inject

class ObserveIntakeUseCase @Inject constructor(private val repo: WaterRepository) {
    operator fun invoke() = repo.todayIntake()
}
