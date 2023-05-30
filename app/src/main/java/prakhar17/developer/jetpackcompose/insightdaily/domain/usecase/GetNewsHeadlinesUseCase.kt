package prakhar17.developer.jetpackcompose.insightdaily.domain.usecase

import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import prakhar17.developer.jetpackcompose.insightdaily.data.util.Resource
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines()
    }
}