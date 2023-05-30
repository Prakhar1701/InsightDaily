package prakhar17.developer.jetpackcompose.insightdaily.domain.usecase

import kotlinx.coroutines.flow.Flow
import prakhar17.developer.jetpackcompose.insightdaily.data.model.Article
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}