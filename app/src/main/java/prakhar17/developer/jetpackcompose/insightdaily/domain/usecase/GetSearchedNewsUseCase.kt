package prakhar17.developer.jetpackcompose.insightdaily.domain.usecase

import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import prakhar17.developer.jetpackcompose.insightdaily.data.util.Resource
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}