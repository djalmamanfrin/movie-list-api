package com.spark.services;

import com.spark.models.Movies;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;
import com.spark.utils.exceptions.InvalidArgumentException;
import java.util.ArrayList;
import java.util.List;

public class MovieListManager {
    private static List<Movies> movies = new ArrayList<>();
    private MovieService service;

    public MovieListManager(MovieService service) {
        this.service = service;
        service.setMovies(movies);
    }

    public static void run() {
        List<MovieListDto> movieList = new CsvFileReader().getMovies();
        movieList.forEach(movieListDto -> movies.add(new Movies(movieListDto)));
    }

    public void execute() throws InvalidArgumentException {
        service.execute();
    }

    public String getResponse() {
        return service.getResponse();
    }
}
