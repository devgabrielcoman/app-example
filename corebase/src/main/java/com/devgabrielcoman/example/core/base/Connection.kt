package com.devgabrielcoman.example.core.base

/**
 * defines a type that can call a server via HTTP against an environment
 */
interface Connection {
    val environment: Environment

    interface Request {
        val path: String
        val method: Method
        val query: Map<String, Any>
        val body: Map<String, Any>
    }

    interface Environment {
        val domain: String
    }

    @Throws
    suspend fun connect(request: Request): String
}