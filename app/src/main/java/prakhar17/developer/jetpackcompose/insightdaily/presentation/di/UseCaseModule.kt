package prakhar17.developer.jetpackcompose.insightdaily.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository
import prakhar17.developer.jetpackcompose.insightdaily.domain.usecase.GetNewsHeadlinesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsHeadlinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }
}