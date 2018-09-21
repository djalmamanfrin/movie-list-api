package com.spark.serives.winnersStudios;

import com.spark.models.Movies;
import com.spark.models.Studios;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class WinnerStudios
 * Service responsible to get studios winner and sort by descending order
 */
public class WinnersStudios {
    private CsvFileReader reader;
    private List<Movies> movies;
    private List<Studios> studios;
    private List<WinnersStudiosTupleDto> tupleDto;

    public WinnersStudios() {
        movies = new ArrayList<>();
        studios = new ArrayList<>();
        reader = new CsvFileReader();
    }

    public void execute() {
        List<MovieListDto> movieList = reader.getMovies();
        movieList.stream().filter(this::byWinner)
          .forEach(movie -> movies.add(new Movies(movie)));

        this.movies.forEach(movie -> studios.addAll(movie.getStudios()));

        Map<String, Integer> counts = new HashMap<>();
        studios.forEach(studio -> counts.merge(studio.getName(), 1, Integer::sum));

        tupleDto = counts.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .map(studio -> new WinnersStudiosTupleDto(studio.getKey(), studio.getValue()))
            .collect(Collectors.toList());
    }

    private Boolean byWinner(MovieListDto movie) {
        return movie.getWinner();
    }

    public List<WinnersStudiosTupleDto> getStudiosCounts() {
        return tupleDto;
    }
}
