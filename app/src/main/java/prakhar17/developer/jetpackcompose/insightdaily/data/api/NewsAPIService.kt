package prakhar17.developer.jetpackcompose.insightdaily.data.api

import prakhar17.developer.jetpackcompose.insightdaily.BuildConfig
import prakhar17.developer.jetpackcompose.insightdaily.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY,
        @Query("country")
        country: String,
        @Query("page")
        page: Int
    ): Response<APIResponse>
}