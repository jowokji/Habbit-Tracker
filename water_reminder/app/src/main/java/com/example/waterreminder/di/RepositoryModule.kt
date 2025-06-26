package com.example.waterreminder.di

import com.example.waterreminder.data.local.IntakeDao
import com.example.waterreminder.data.remote.GoalRemoteDataSource
import com.example.waterreminder.data.repository.WaterRepositoryImpl
import com.example.waterreminder.domain.repository.WaterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepo(dao: IntakeDao, remote: GoalRemoteDataSource): WaterRepository =
        WaterRepositoryImpl(dao, remote)
}
