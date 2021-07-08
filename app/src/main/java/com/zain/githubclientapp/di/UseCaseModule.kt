package com.zain.githubclientapp.di

import com.zain.githubclientapp.repository.DataRepository
import com.zain.githubclientapp.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {
    @Provides
    fun providesDataUseCase(dataRepository: DataRepository): DataUseCase {
        return DataUseCase(dataRepository)
    }
}