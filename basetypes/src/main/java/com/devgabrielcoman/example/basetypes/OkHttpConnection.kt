package com.devgabrielcoman.example.basetypes

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Method
import kotlinx.coroutines.async
import okhttp3.OkHttpClient
import java.net.SocketException

class OkHttpConnection(override val environment: Connection.Environment) : Connection {

    private val client = OkHttpClient()

    private fun Method.toOkHttpString(): String = when (this) {
        Method.GET -> "GET"
        Method.DELETE -> "DELETE"
        Method.POST -> "POST"
        Method.PUT -> "PUT"
    }

    @Throws
    override suspend fun connect(request: Connection.Request): String {

        val domain = environment.domain.trimEnd { it == '/' }
        val endpoint = request.path.trimStart { it == '/' }
        val url = "$domain/$endpoint"

        val okRequest = okhttp3.Request.Builder()
            .url(url)
            .method(request.method.toOkHttpString(), null)
            .build()

        val deferred = async { return@async client.newCall(okRequest).execute() }

        val response = deferred.await()

        return response.body()?.string() ?: throw SocketException()
    }
}