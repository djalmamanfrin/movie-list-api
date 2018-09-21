package com.spark.serives.rangesOfAwards;

import com.spark.models.Movies;
import com.spark.models.Producers;
import com.spark.utils.csv.CsvFileReader;
import com.spark.utils.csv.MovieListDto;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HigherAndLowerRangesOfAwards {
    private CsvFileReader reader;
    private List<Movies> movies;
    private List<Producers> producers;
    private List<RangesOfAwardsDto> result;

    public HigherAndLowerRangesOfAwards() {
        movies = new ArrayList<>();
        producers = new ArrayList<>();
        result = new ArrayList<>();
        reader = new CsvFileReader();
    }

    public void execute() {
        List<MovieListDto> movieList = reader.getMovies();
        movieList.stream().filter(this::byWinner)
                .forEach(movie -> movies.add(new Movies(movie)));

        this.movies.forEach(movie -> producers.addAll(movie.getProducers()));

        Map<String, Optional<Producers>> maxWinnerPerYear = producers.stream()
                .collect(Collectors.groupingBy(Producers::getName,
                        Collectors.maxBy(Comparator.comparingInt(Producers::getYear))));

        Map<String, Optional<Producers>> minWinnerPerYear = producers.stream()
                .collect(Collectors.groupingBy(Producers::getName,
                        Collectors.minBy(Comparator.comparingInt(Producers::getYear))));

//        HashMap<String, List<Producers>> test = new HashMap<>();
//
//        minWinnerPerYear.forEach((k, v) -> {
//            if(maxWinnerPerYear.containsKey(k)) {
//                List<Producers> array = new ArrayList<>();
//                array.add(v.get());
//                array.add(maxWinnerPerYear.get(k).get());
//                test.put(k, array);
//            }
//        });
//        System.out.println("");


        System.out.println(maxWinnerPerYear);
    }

    private Boolean byWinner(MovieListDto movie) {
        return movie.getWinner();
    }

    public List<RangesOfAwardsDto> getRangesOfAwards() {
        return result;
    }
}
