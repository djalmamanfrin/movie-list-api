package com.spark.http.controllers.v1;

import com.google.gson.Gson;
import com.spark.serives.MovieListManager;
import com.spark.serives.WinnersByYear;
import com.spark.serives.winnersStudios.WinnersStudios;
import com.spark.serives.yearsWithWinners.YearsWithMoreOneWinner;
import com.spark.serives.rangesOfAwards.HigherAndLowerRangesOfAwards;
import spark.Request;
import spark.Response;

public class MoviesController {
    public static String moviesByYear(Request request, Response response) {
        String year = request.params("year");
        return new Gson().toJson(MovieListManager.moviesByYear(year));
    }

    public static String yearsWithMoreOneWinner(Request request, Response response) {
        return new Gson().toJson(MovieListManager.yearsWithMoreOneWinner());
    }

    public static String winnersStudios(Request request, Response response) {
        return new Gson().toJson(MovieListManager.winnersStudios());
    }

    public static String rangesOfAwards(Request request, Response response) {
        return new Gson().toJson(MovieListManager.rangesOfAwards());
    }
}
