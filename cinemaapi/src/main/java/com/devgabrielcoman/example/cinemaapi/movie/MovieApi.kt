package com.devgabrielcoman.example.cinemaapi.movie

import com.devgabrielcoman.example.core.api.Api

/**
 * a MovieApi is a specific type that
 * - takes as input a String (Movie ID)
 * - outputs a Movie Model
 */
interface MovieApi: Api<String, Movie>