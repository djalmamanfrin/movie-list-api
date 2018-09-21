package com.spark.serives;

import com.spark.models.Movies;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;
import java.util.ArrayList;
import java.util.List;

/**
 * Class WinnersByYear
 */
public class WinnersByYear {
    private String year;
    private CsvFileReader reader;
    private List<Movies> movie;

    public WinnersByYear(String year) {
        this.year = year;
        movie = new ArrayList<>();
        reader = new CsvFileReader();
    }

    public void execute() {
        List<MovieListDto> movieList = reader.getMovies();
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
