package com.spark.serives.rangesOfAwards;

import com.spark.models.Movies;
import com.spark.models.Producers;
import java.util.*;
import java.util.stream.Collectors;

public class HigherAndLowerRangesOfAwards {
    private List<Movies> movies;
    private List<Producers> producers;
    private HashMap<String, RangesOfAwardsDto> map;

    public HigherAndLowerRangesOfAwards(List<Movies> movies) {
        producers = new ArrayList<>();
        map = new HashMap<>();
        this.movies = movies;
    }

    public void execute() {
        List<Movies> moviesPerWinner = movies.stream().filter(this::byWinner).collect(Collectors.toList());
        moviesPerWinner.forEach(movie -> producers.addAll(movie.getProducers()));

        Map<String, Integer> counts = new HashMap<>();
        producers.forEach(producer -> counts.merge(producer.getName(), 1, Integer::sum));

        Map<String, Integer> producerMoreOneWinner = counts.entrySet().stream()
                .filter(map -> map.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        List<RangesOfAwardsDto> result = new ArrayList<>();
        producerMoreOneWinner.entrySet().forEach(p -> {
            Producers maxPerYear = producers.stream()
                    .filter(producer -> producer.getName().equals(p.getKey()))
                    .max(Comparator.comparing(Producers::getYear))
                    .orElseThrow(NoSuchElementException::new);
            Producers minPerYear = producers.stream()
                    .filter(producer -> producer.getName().equals(p.getKey()))
                    .min(Comparator.comparing(Producers::getYear))
                    .orElseThrow(NoSuchElementException::new);

            RangesOfAwardsDto rangesOfAwards = new RangesOfAwardsDto();
            rangesOfAwards.setProducer(maxPerYear.getName());
            rangesOfAwards.setFollowingWin(maxPerYear.getYear());
            rangesOfAwards.setPreviousWin(minPerYear.getYear());
            rangesOfAwards.setInterval(maxPerYear.getYear() - minPerYear.getYear());
            result.add(rangesOfAwards);
        });

        Comparator <RangesOfAwardsDto> comparator = Comparator.comparingInt(RangesOfAwardsDto::getInterval);
        RangesOfAwardsDto MaxRangesOfAwards = result.stream().max(comparator).get();
        RangesOfAwardsDto MinRangesOfAwards = result.stream().min(comparator).get();
        result.clear();
        map.put("max", MaxRangesOfAwards);
        map.put("min", MinRangesOfAwards);
    }

    private Boolean byWinner(Movies movie) {
        return movie.getWinner();
    }

    public HashMap<String, RangesOfAwardsDto> getRangesOfAwards() {
        return map;
    }
}
