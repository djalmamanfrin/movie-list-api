package com.spark.services.winnersStudios;

import com.google.gson.Gson;
import com.spark.models.Movies;
import com.spark.models.Studios;
import com.spark.services.MovieService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class WinnerStudios
 * Service responsible to get studios winner and sort by descending order
 */
public class WinnersStudios implements MovieService {
    private List<Studios> studios;
    private List<WinnersStudiosTupleDto> tupleDto;
    private List<Movies> movies;

    public WinnersStudios() {
        studios = new ArrayList<>();
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public void execute() {
        List<Movies> moviesPerWinner = movies.stream().filter(this::byWinner).collect(Collectors.toList());
        moviesPerWinner.forEach(movie -> studios.addAll(movie.getStudios()));

        Map<String, Integer> studiosCounts = new HashMap<>();
        studios.forEach(studio -> studiosCounts.merge(studio.getName(), 1, Integer::sum));

        tupleDto = studiosCounts.entrySet().stream()
                .filter(studio -> studio.getValue() > 1)
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(studio -> new WinnersStudiosTupleDto(studio.getKey(), studio.getValue()))
                .collect(Collectors.toList());
    }

    private Boolean byWinner(Movies movie) {
        return movie.getWinner();
    }

    public String getResponse() {
        return new Gson().toJson(tupleDto);
    }
}
