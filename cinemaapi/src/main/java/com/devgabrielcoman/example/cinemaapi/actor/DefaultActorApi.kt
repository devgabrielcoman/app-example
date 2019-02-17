package com.devgabrielcoman.example.cinemaapi.actor

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Method
import com.devgabrielcoman.example.core.base.Parser

class DefaultActorApi(override val connection: Connection, override val parser: Parser) : ActorApi {

    override suspend fun call(input: String): Actor {
        val request = Request(actorId = input)
        val response = connection.connect(request = request)
        return parser.parse(type = Actor::class.java, data = response)
    }

    internal data class Request(val actorId: String): Connection.Request {
        override val path: String = "/v1/actors/$actorId"
        override val method: Method = Method.GET
        override val query: Map<String, Any> = mapOf()
        override val body: Map<String, Any> = mapOf()
    }
}