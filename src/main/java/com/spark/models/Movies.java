package com.spark.models;

import com.spark.utils.csv.MovieListDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Movies {
    private String movieId;
    private String tittle;
    private String year;
    private Boolean winner;
    private Boolean active;
    private List<Producers> producers = new ArrayList<>();
    private List<Studios> studios = new ArrayList<>();

    public Movies(MovieListDto movieList) {
        movieId = UUID.randomUUID().toString();
        this.tittle = movieList.getTitle();
        this.year = movieList.getYear();
        this.winner = movieList.getWinner();
        movieList.getProducers().forEach(producerName -> producers.add(new Producers(producerName, movieList.getYear())));
        movieList.getStudios().forEach(studiosName -> studios.add(new Studios(studiosName)));
        active = true;
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

    public Boolean getActive() {
        return active;
    }

    public void toggleActive(Boolean toggle) {
        active = toggle;
    }

    public List<Studios> getStudios() {
        return studios;
    }

    public List<Producers> getProducers() {
        return producers;
    }
}
