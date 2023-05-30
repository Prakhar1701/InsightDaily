package prakhar17.developer.jetpackcompose.insightdaily.domain.repository

import kotlinx.coroutines.flow.Flow
import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import prakhar17.developer.jetpackcompose.insightdaily.data.model.Article
import prakhar17.developer.jetpackcompose.insightdaily.data.util.Resource

interface NewsRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}