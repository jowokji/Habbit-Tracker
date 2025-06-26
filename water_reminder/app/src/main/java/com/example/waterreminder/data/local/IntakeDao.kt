package com.example.waterreminder.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface IntakeDao {
    @Query("SELECT * FROM intake WHERE date(timestamp/1000,'unixepoch','localtime') = date('now','localtime')")
    fun todayStream(): Flow<List<WaterIntakeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(intake: WaterIntakeEntity)
}
