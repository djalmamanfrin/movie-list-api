package com.spark.serives.winnersStudios;

import com.spark.models.Movies;
import com.spark.models.Studios;
import com.spark.utils.csv.MovieListDto;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class WinnerStudios
 * Service responsible to get studios winner and sort by descending order
 */
public class WinnersStudios {
    private List<Studios> studios;
    private List<WinnersStudiosTupleDto> tupleDto;
    private List<Movies> movies;

    public WinnersStudios(List<Movies> movies) {
        studios = new ArrayList<>();
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

    public List<WinnersStudiosTupleDto> getStudiosCounts() {
        return tupleDto;
    }
}
