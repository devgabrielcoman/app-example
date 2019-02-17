package com.devgabrielcoman.example.core.api

import com.devgabrielcoman.example.core.base.Connection
import com.devgabrielcoman.example.core.base.Parser

/**
 * defines an operation that takes in any Input type and outputs a Model
 */
interface Api <in Input, out Model> {
    val connection: Connection
    val parser: Parser

    @Throws
    suspend fun call(input: Input): Model
}