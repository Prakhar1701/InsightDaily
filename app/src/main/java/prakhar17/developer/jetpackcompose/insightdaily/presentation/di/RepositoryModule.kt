package prakhar17.developer.jetpackcompose.insightdaily.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import prakhar17.developer.jetpackcompose.insightdaily.data.repository.NewsRepositoryImpl
import prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSource.NewsRemoteDataSource
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}