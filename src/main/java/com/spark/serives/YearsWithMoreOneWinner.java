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

public class YearsWithMoreOneWinner {
    // private CsvFileReader reader;
    private List<MovieListDto> movieList;
    private Map<String, Long> winnersCounts;

    public YearsWithMoreOneWinner() {
        winnersCounts = new HasMap<>();
        movieList = reader.getMovies();
        // reader = new CsvFileReader();
    }

    public void execute() {
      winnersCounts = movieList.stream().flatMap(MovieListDto::getYear)
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        // List<MovieListDto> movies = reader.getMovies();
        // Integer moviesSize = movieList.size();
        // for (Integer aux = 0; aux <= moviesSize; aux++) {
        //   movieList.stream().filter(this::byYear)
        //     .forEach(movie -> this.movie.add(new Movies(movie)));
        // }
    }

    private Boolean order(HashMap unsortMap) {
        Map<String, Integer> result = unsortMap.entrySet().stream()
          .sorted(Map.Entry.comparingByKey())
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                  (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }

    public Map<String, Long> getWinnersCounts() {
        return order(winnersCounts);
    }
}
