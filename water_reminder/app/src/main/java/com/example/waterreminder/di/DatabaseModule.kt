package com.example.waterreminder.di

import android.content.Context
import androidx.room.Room
import com.example.waterreminder.data.local.WaterDb
import com.example.waterreminder.data.local.IntakeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext ctx: Context): WaterDb =
        Room.databaseBuilder(ctx, WaterDb::class.java, "water.db").build()

    @Provides
    fun provideDao(db: WaterDb): IntakeDao = db.intakeDao()
}
