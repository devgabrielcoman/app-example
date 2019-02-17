package com.devgabrielcoman.example.app

import com.devgabrielcoman.example.basetypes.MoshiParser
import com.devgabrielcoman.example.basetypes.OkHttpConnection
import com.devgabrielcoman.example.cinemaapi.Environments
import com.devgabrielcoman.example.cinemaapi.actor.DefaultActorApi
import com.devgabrielcoman.example.cinemaapi.movie.DefaultMovieApi

object Apis {

    private val environment = Environments.Production()
    private val connection = OkHttpConnection(environment = environment)
    private val parser = MoshiParser()

    val movies = DefaultMovieApi(connection = connection, parser = parser)
    val actors = DefaultActorApi(connection = connection, parser = parser)
}