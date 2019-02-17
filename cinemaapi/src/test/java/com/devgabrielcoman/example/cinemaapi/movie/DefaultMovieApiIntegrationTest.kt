package com.devgabrielcoman.example.cinemaapi.movie

import com.devgabrielcoman.example.basetypes.MoshiParser
import com.devgabrielcoman.example.basetypes.OkHttpConnection
import com.devgabrielcoman.example.core.base.Connection
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class DefaultMovieApiIntegrationTest {

    private val server = MockWebServer()
    private lateinit var environment: Connection.Environment
    private lateinit var connection: Connection
    private val parser = MoshiParser()

    @Throws(exceptionClasses = [IOException::class])
    @Before
    fun `setUp environment`() {
        server.start()
        val domain = server.url("").toString()
        environment = MockEnvironment(domain = domain)
        connection = OkHttpConnection(environment = environment)
    }

    @Throws(exceptionClasses = [IOException::class])
    @After
    fun `End environment`() {
        server.shutdown()
    }

    @Test
    fun test_IntegrationWith_OkHttpConnection_AndMoshi() = runBlocking {
        // given
        val expectedResponse = "{\"id\":\"my-movie-id\", \"title\":\"test\"}"
        val serverResponse = MockResponse().setBody(expectedResponse)
        server.enqueue(serverResponse)

        val api = DefaultMovieApi(connection = connection, parser = parser)

        // when
        val model = api.call(input = "my-movie-id")

        // then
        Assert.assertEquals("my-movie-id", model.id)
    }

    private data class MockEnvironment(override val domain: String): Connection.Environment
}