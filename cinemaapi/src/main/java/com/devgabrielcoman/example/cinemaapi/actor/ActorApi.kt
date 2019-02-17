package com.devgabrielcoman.example.cinemaapi.actor

import com.devgabrielcoman.example.core.api.Api

/**
 * an ActorApi is a specific type that
 * - takes as input a String (Actor ID)
 * - outputs a Actor Model
 */
interface ActorApi: Api<String, Actor>