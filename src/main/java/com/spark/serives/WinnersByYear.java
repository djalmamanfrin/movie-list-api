package com.spark.serives;

import com.spark.models.Movies;
import com.spark.utils.csv.MovieListDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class WinnersByYear
 */
public class WinnersByYear {
    private String year;
    private List<Movies> movie;
    private List<Movies> moviesPerYear;

    WinnersByYear(String year, List<Movies> movie) {
        this.year = year;
        this.movie = movie;
    }

    void execute() {
        moviesPerYear = movie.stream().filter(this::byYear).collect(Collectors.toList());
    }

    private Boolean byYear(Movies movie) {
        return movie.getYear().equals(year);
    }

    List<Movies> getMovies() {
        return moviesPerYear;
    }
}
