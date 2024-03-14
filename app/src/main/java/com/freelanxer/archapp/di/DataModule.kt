package com.freelanxer.archapp.di

import com.freelanxer.archapp.data.DataRepository
import com.freelanxer.archapp.data.DataRepositoryResource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: DataRepository): DataRepositoryResource
}