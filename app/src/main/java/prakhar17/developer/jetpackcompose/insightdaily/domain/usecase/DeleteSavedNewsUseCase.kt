package prakhar17.developer.jetpackcompose.insightdaily.domain.usecase

import prakhar17.developer.jetpackcompose.insightdaily.data.model.Article
import prakhar17.developer.jetpackcompose.insightdaily.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}