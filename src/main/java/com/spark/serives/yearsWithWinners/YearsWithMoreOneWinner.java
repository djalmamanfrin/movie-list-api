package com.spark.serives.yearsWithWinners;

import com.spark.models.Movies;
import com.spark.models.Producers;
import com.spark.models.Studios;
import com.spark.serives.rangesOfAwards.RangesOfAwardsDto;
import com.spark.serives.winnersStudios.WinnersStudiosTupleDto;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YearsWithMoreOneWinner {
    private CsvFileReader reader;
    private Map<String, Integer> winnersCounts;
    private List<YearsWinnersDto> yearsWinners;

    public YearsWithMoreOneWinner() {
        reader = new CsvFileReader();
        winnersCounts = new HashMap<>();
        yearsWinners = new ArrayList<>();
    }

    public void execute() {
        List<MovieListDto> movieList = reader.getMovies();

        movieList.stream().filter(this::byWinner)
                .forEach(movie -> winnersCounts.merge(movie.getYear(), 1, Integer::sum));

        yearsWinners = winnersCounts.entrySet().stream()
                .filter(studio -> studio.getValue() > 1)
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(studio ->  new YearsWinnersDto(studio.getKey(), studio.getValue()))
                .collect(Collectors.toList());

        System.out.println(yearsWinners);
    }

    private Boolean byWinner(MovieListDto movie) {
        return movie.getWinner();
    }

    public List<YearsWinnersDto> getWinnersCounts() {
        return yearsWinners;
    }
}
