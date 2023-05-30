package prakhar17.developer.jetpackcompose.insightdaily.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import prakhar17.developer.jetpackcompose.insightdaily.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charset.defaultCharset()))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("news_response.json")
            val responseBody = service.getTopHeadlines(country = "us", page = 1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?apiKey=${BuildConfig.API_KEY}&country=us&page=1")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("news_response.json")
            val responseBody = service.getTopHeadlines(country = "us", page = 1).body()
            val articlesList = responseBody!!.articles
            assertThat(articlesList.size).isEqualTo(20) //Default is 20
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("news_response.json")
            val responseBody = service.getTopHeadlines(country = "us", page = 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("Jessie Gretener,Sugam Pokharel,Tara John,Sharon Braithwaite")
            assertThat(article.url).isEqualTo("https://www.cnn.com/2023/05/29/europe/northern-kosovo-nato-serbian-clashes-intl/index.html")
            assertThat(article.publishedAt).isEqualTo("2023-05-29T21:28:00Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}