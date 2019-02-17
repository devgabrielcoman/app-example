package com.devgabrielcoman.example.cinemaapi.movie

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Parser
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.net.SocketException

class DefaultMovieApiTest {

    private val environment = MockEnvironment("")
    private val connection = StubConnection(environment = environment)
    private val parser = StubParser()

    @Test
    fun `movieApi toReturn CorrectData`() = runBlocking {
        // given
        val api = DefaultMovieApi(connection = connection, parser = parser)

        // when
        val result = api.call(input = "movie-id-1")

        // then
        Assert.assertEquals("movie-id-1", result.id)
        Assert.assertEquals("Great Gatsby", result.title)
    }

    object StubRemoteResource {
        const val successMovieResponse = "{\"id\":\"movie-id-1\", \"title\":\"Great Gatsby\"}"
    }

    class StubConnection(override val environment: Connection.Environment) : Connection {

        override suspend fun connect(request: Connection.Request): String = when (request) {
            is DefaultMovieApi.Request -> StubRemoteResource.successMovieResponse
            else -> throw SocketException()
        }
    }

    private class StubParser: Parser {
        override suspend fun <Model> parse(type: Class<Model>, data: String): Model = when (data) {
            StubRemoteResource.successMovieResponse -> Movie(id = "movie-id-1", title = "Great Gatsby") as Model
            else -> throw Throwable()
        }
    }

    private class MockEnvironment(override val domain: String) : Connection.Environment
}