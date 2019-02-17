package com.devgabrielcoman.example.cinemaapi.movie

import com.devgabrielcoman.example.core.base.Method
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MovieApiRequestTest {

    @Test
    fun `movieApiRequest ToHave CorrectValues`() {
        // given
        val movieId = "my-movie-id"

        // when
        val request = DefaultMovieApi.Request(movieId = movieId)

        // then
        assertEquals("/v1/movies/my-movie-id", request.path)
        assertEquals(Method.GET, request.method)
        assertTrue(request.query.isEmpty())
        assertTrue(request.body.isEmpty())
    }
}