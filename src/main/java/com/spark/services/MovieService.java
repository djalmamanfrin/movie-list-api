package com.spark.services;

import com.spark.models.Movies;
import com.spark.utils.exceptions.InvalidArgumentException;

import java.util.List;

public interface MovieService {
    void execute() throws InvalidArgumentException;
    String getResponse();
    void setMovies(List<Movies> movies);
}
