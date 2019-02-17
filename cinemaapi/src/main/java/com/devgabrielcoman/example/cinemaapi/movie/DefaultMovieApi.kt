package com.devgabrielcoman.example.cinemaapi.movie

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Method
import com.devgabrielcoman.example.core.base.Parser

class DefaultMovieApi(override val connection: Connection, override val parser: Parser): MovieApi {

    override suspend fun call(input: String): Movie {
        val request = Request(movieId = input)
        val response = connection.connect(request = request)
        return parser.parse(type = Movie::class.java, data = response)
    }

    internal data class Request(val movieId: String): Connection.Request {
        override val method: Method = Method.GET
        override val path: String = "/v1/movies/$movieId"
        override val query: Map<String, Any> = mapOf()
        override val body: Map<String, Any> = mapOf()
    }
}