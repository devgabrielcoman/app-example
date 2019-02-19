package com.devgabrielcoman.example.core.api

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Parser

/**
 * An Api is any type that works on an input and outputs a Model
 */
interface Api <in Input, out Model> {
    /**
     * Any Api will make use of a Connection and a Parser
     * - Connection will obtain the remote resource (in a raw String format)
     * - Parser will transform that into a POJO
     */
    val connection: Connection
    val parser: Parser

    /**
     * An Api will have one main method - call - that operates on an Input and outputs a Model
     * @param input any input type (a string, a complex object containing more details, etc)
     * @return any Model type
     * @throws Throwable might forward or throw any type of network or parsing error
     */
    @Throws
    suspend fun call(input: Input): Model
}