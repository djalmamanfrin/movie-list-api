package com.spark.serives;

import com.spark.models.Movies;
import com.spark.models.Producers;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;

import java.util.ArrayList;
import com.spark.models.Studios;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class WinnersByYear {
    private String year;
    // private CsvFileReader reader;
    private List<MovieListDto> movieList;
    private List<Movies> movie;

    public WinnersByYear(String year) {
        this.year = year;
        movie = new ArrayList<>();
        movieList = reader.getMovies();
        // reader = new CsvFileReader();
    }

    public void execute() {
        // List<MovieListDto> movies = reader.getMovies();
        movieList.stream().filter(this::byYear)
          .forEach(movie -> this.movie.add(new Movies(movie)));
    }

    private Boolean byYear(MovieListDto movie) {
        return movie.getYear().equals(year);
    }

    public List<Movies> getMovies() {
        return movie;
    }
}
