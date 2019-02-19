package com.devgabrielcoman.example.core.base

/**
 * A Parser is any type that transforms a raw String into a Model
 */
interface Parser {
    /**
     * A Parser will have one method - parser
     * @param type the actual type of the Model (e.g. MyModel::class.java)
     * @param data the raw data, in JSON, XML or any other format
     * @return a new instance of a Model, parsed from the raw data string
     * @throws Throwable any error surfaced by the low-level JSON parsing lib
     */
    @Throws
    suspend fun <Model> parse(type: Class<Model>, data: String): Model
}