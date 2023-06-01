package prakhar17.developer.jetpackcompose.insightdaily.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import prakhar17.developer.jetpackcompose.insightdaily.data.api.NewsAPIService
import prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSource.NewsRemoteDataSource
import prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}