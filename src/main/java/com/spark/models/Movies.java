package com.spark.models;

import com.spark.utils.csv.MovieListDto;
import java.util.ArrayList;
import java.util.List;

public class Movies {
    private String tittle;
    private String year;
    private Boolean winner;
    private List<Producers> producers = new ArrayList<>();
    private List<Studios> studios = new ArrayList<>();

    public Movies(MovieListDto movieList) {
        this.tittle = movieList.getTitle();
        this.year = movieList.getYear();
        this.winner = movieList.getWinner();
        movieList.getProducers().forEach(producerName -> producers.add(new Producers(producerName, movieList.getYear())));
        movieList.getStudios().forEach(studiosName -> studios.add(new Studios(studiosName)));
    }

    public String getTittle() {
        return tittle;
    }

    public String getYear() {
        return year;
    }

    public Boolean getWinner() {
        return winner;
    }

    public List<Studios> getStudios() {
        return studios;
    }

    public List<Producers> getProducers() {
        return producers;
    }
}
