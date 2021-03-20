package com.tolerans.vitrinova.di

import com.tolerans.vitrinova.data.VitrinovaAPI
import com.tolerans.vitrinova.repositories.DefaultMainRepository
import com.tolerans.vitrinova.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(api:VitrinovaAPI):MainRepository = DefaultMainRepository(api)

}