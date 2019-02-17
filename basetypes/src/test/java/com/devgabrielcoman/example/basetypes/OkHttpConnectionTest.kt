package com.devgabrielcoman.example.basetypes

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Method
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class OkHttpConnectionTest {

    private val server = MockWebServer()
    private lateinit var environment: Connection.Environment
    private lateinit var connection: Connection

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
    fun `connection ToReturn CorrectSuccess`() = runBlocking {
        // given
        val expectedResponse = "{\"id\":3, \"name\":\"test\"}"
        val serverResponse = MockResponse().setBody(expectedResponse)
        server.enqueue(serverResponse)

        // when
        val request = MockRequest()
        val actualResponse = connection.connect(request = request)

        // then
        Assert.assertEquals(expectedResponse, actualResponse)
    }

    private data class MockEnvironment(override val domain: String) : Connection.Environment

    private class MockRequest: Connection.Request {
        override val path: String = "/my/path"
        override val method: Method = Method.GET
        override val query: Map<String, Any> = mapOf()
        override val body: Map<String, Any> = mapOf()
    }
}