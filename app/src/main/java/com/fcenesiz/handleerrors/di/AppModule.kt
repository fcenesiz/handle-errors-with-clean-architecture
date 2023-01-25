package com.fcenesiz.handleerrors.di

import com.fcenesiz.handleerrors.data.MyRepositoryImpl
import com.fcenesiz.handleerrors.domain.MyRepository
import com.fcenesiz.handleerrors.domain.SubmitEmailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMyRepository(): MyRepository = MyRepositoryImpl()

    @Singleton
    @Provides
    fun provideSubmitEmailUseCase(
        repository: MyRepository
    ): SubmitEmailUseCase = SubmitEmailUseCase(repository)

}