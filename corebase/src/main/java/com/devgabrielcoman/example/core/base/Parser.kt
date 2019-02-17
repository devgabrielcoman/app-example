package com.devgabrielcoman.example.core.base

/**
 * defines a type that transforms a String into a Model
 */
interface Parser {
    @Throws
    suspend fun <Model> parse(type: Class<Model>, data: String): Model
}