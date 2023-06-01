package prakhar17.developer.jetpackcompose.insightdaily.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import prakhar17.developer.jetpackcompose.insightdaily.domain.usecase.GetNewsHeadlinesUseCase
import prakhar17.developer.jetpackcompose.insightdaily.presentation.viewmodel.NewsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase)
    }
}