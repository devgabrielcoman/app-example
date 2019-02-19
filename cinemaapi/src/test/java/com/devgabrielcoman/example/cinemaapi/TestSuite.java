package com.devgabrielcoman.example.cinemaapi;

import com.devgabrielcoman.example.cinemaapi.movie.DefaultMovieApiIntegrationTest;
import com.devgabrielcoman.example.cinemaapi.movie.DefaultMovieApiTest;
import com.devgabrielcoman.example.cinemaapi.movie.MovieApiRequestTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DefaultMovieApiIntegrationTest.class,
        DefaultMovieApiTest.class,
        MovieApiRequestTest.class
})
public class TestSuite {}