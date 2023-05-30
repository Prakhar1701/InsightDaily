package prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSourceImpl

import prakhar17.developer.jetpackcompose.insightdaily.data.api.NewsAPIService
import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country = country, page = page)
    }
}