package com.devgabrielcoman.example.cinemaapi

import com.devgabrielcoman.example.core.base.Connection

sealed class Environments: Connection.Environment {
    data class Production(override val domain: String = "https://movie.api.com/") : Environments()
    data class Staging(override val domain: String = "https://movie.staging.api.com/"): Environments()
    data class Development(override val domain: String = "https://localhost:85821/") : Environments()
}