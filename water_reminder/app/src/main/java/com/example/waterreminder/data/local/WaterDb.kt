package com.example.waterreminder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WaterIntakeEntity::class], version = 1, exportSchema = false)
abstract class WaterDb : RoomDatabase() {
    abstract fun intakeDao(): IntakeDao
}
