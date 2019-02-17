package com.devgabrielcoman.example.basetypes

import com.devgabrielcoman.example.core.base.Parser
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi

class MoshiParser: Parser {

    private val moshi = Moshi.Builder().build()

    @Throws
    override suspend fun <Model> parse(type: Class<Model>, data: String): Model {
        return moshi.adapter<Model>(type).fromJson(data) ?: throw JsonDataException()
    }
}