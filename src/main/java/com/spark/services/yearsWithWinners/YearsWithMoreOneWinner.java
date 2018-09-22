package com.spark.services.yearsWithWinners;


import com.google.gson.Gson;
import com.spark.models.Movies;
import com.spark.services.MovieService;

import java.util.*;
import java.util.stream.Collectors;

public class YearsWithMoreOneWinner implements MovieService {
    private Map<String, Integer> winnersCounts;
    private List<YearsWinnersDto> yearsWinners;
    private List<Movies> movies;

    public YearsWithMoreOneWinner() {
        winnersCounts = new HashMap<>();
        yearsWinners = new ArrayList<>();
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public void execute() {
        movies.stream().filter(this::byWinner)
                .forEach(movie -> winnersCounts.merge(movie.getYear(), 1, Integer::sum));

        yearsWinners = winnersCounts.entrySet().stream()
                .filter(studio -> studio.getValue() > 1)
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(studio ->  new YearsWinnersDto(studio.getKey(), studio.getValue()))
                .collect(Collectors.toList());
    }

    private Boolean byWinner(Movies movie) {
        return movie.getWinner();
    }

    public String getResponse() {
        return new Gson().toJson(yearsWinners);
    }
}
