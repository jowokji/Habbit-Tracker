package com.example.waterreminder.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "intake")
data class WaterIntakeEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val timestamp: Long,
    val amountMl: Int
)
