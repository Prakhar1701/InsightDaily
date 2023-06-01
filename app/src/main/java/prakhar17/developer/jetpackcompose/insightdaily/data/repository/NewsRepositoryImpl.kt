package prakhar17.developer.jetpackcompose.insightdaily.data.repository

import kotlinx.coroutines.flow.Flow
import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import prakhar17.developer.jetpackcompose.insightdaily.data.model.Article
import prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSource.NewsRemoteDataSource
import prakhar17.developer.jetpackcompose.insightdaily.data.util.Resource
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines(country, page))
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

}