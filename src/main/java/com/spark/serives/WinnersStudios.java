package com.spark.serives;

import com.spark.models.Movies;
import com.spark.models.Producers;
import com.spark.models.Studios;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class WinnersStudios {
    private List<MovieListDto> movieList;
    private List<Movies> movies;
    private List<Studios> studios;
    private Map<String, Long> result;

    public WinnersByYear() {
        movies = new ArrayList<>();
        studios = new ArrayList<>();
        movieList = reader.getMovies();
    }

    public void execute() {
        movieList.stream().filter(movieList.getWinner())
          .forEach(movie -> movies.add(new Movies(movie)));

        this.movies.forEach(movie ->
          movie.forEach(studio -> studios.add(studio)));

        Map<Double,Long> studiosCount = studios.stream()
          .collect(Collectors.groupingBy(Studios::getName,Collectors.counting()));

        result = map.entrySet().stream()
        	.sorted(Map.Entry.comparingByKey())
        	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        	(oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Map<String, Long> getStudiosCounts() {
        return result;
    }
}
