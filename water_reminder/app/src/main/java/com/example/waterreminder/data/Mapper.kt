package com.example.waterreminder.data

import com.example.waterreminder.data.local.WaterIntakeEntity
import com.example.waterreminder.domain.model.WaterIntake

fun WaterIntakeEntity.toDomain() = WaterIntake(id, timestamp, amountMl)
fun WaterIntake.toEntity() = WaterIntakeEntity(id, timestamp, amountMl)
