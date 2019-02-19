package com.devgabrielcoman.example.core.base

/**
 * A Connection is any type that obtains a remote resource from the network and outputs a raw String
 */
interface Connection {

    /**
     * Any Connection will operate on a given injected environment (production, staging, development, etc)
     */
    val environment: Environment

    /**
     * A Request is any type that defines how a HTTP operation should look like
     */
    interface Request {
        val path: String
        val method: Method
        val query: Map<String, Any>
        val body: Map<String, Any>
    }

    /**
     * A basic Environment is any type that specifies a certain domain
     */
    interface Environment {
        val domain: String
    }

    /**
     * A Connection will have one main method - connect
     * @param request the request will be used to parametrise the HTTP operation
     * @return a raw String, ether a JSON or XML or any other type or response
     * @throws Throwable any type of error surfaced by the low-level networking level
     */
    @Throws
    suspend fun connect(request: Request): String
}