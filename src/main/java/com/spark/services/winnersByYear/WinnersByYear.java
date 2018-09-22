package com.spark.services.winnersByYear;

import com.google.gson.Gson;
import com.spark.models.Movies;
import com.spark.services.MovieService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class WinnersByYear
 */
public class WinnersByYear implements MovieService {
    private String year;
    private List<Movies> movies;
    private List<Movies> moviesPerYear;

    public WinnersByYear(String year) {
        this.year = year;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public void execute() {
        moviesPerYear = movies.stream().filter(this::byYear).collect(Collectors.toList());
    }

    private Boolean byYear(Movies movie) {
        return movie.getYear().equals(year);
    }

    public String getResponse() {
        return new Gson().toJson(moviesPerYear);
    }
}
