package com.spark.serives.yearsWithWinners;


import com.spark.models.Movies;
import java.util.*;
import java.util.stream.Collectors;

public class YearsWithMoreOneWinner {
    private Map<String, Integer> winnersCounts;
    private List<YearsWinnersDto> yearsWinners;
    private List<Movies> movies;

    public YearsWithMoreOneWinner(List<Movies> movies) {
        winnersCounts = new HashMap<>();
        yearsWinners = new ArrayList<>();
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

    public List<YearsWinnersDto> getWinnersCounts() {
        return yearsWinners;
    }
}
