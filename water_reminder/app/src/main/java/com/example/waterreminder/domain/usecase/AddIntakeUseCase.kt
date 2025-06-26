package com.example.waterreminder.domain.usecase

import com.example.waterreminder.domain.repository.WaterRepository
import javax.inject.Inject

class AddIntakeUseCase @Inject constructor(private val repo: WaterRepository) {
    suspend operator fun invoke(amountMl: Int) = repo.addIntake(amountMl)
}
