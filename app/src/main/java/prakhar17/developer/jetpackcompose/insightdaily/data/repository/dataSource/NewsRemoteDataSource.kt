package prakhar17.developer.jetpackcompose.insightdaily.data.repository.dataSource

import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(): Response<APIResponse>
}