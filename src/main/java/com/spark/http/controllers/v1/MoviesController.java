package com.spark.http.controllers.v1;

import com.google.gson.Gson;
import com.spark.serives.WinnersByYear;
import com.spark.serives.winnersStudios.WinnersStudios;
import com.spark.serives.yearsWithWinners.YearsWithMoreOneWinner;
import com.spark.serives.rangesOfAwards.HigherAndLowerRangesOfAwards;
import spark.Request;
import spark.Response;

public class MoviesController {
    public static String moviesByYear(Request request, Response response) {
        String year = request.queryParams("year");
        WinnersByYear winnersByYear = new WinnersByYear(year);
        try {
            winnersByYear.execute();
        } catch (Exception e) {
            response.status(404);
//            json.render();
        }
        return new Gson().toJson(winnersByYear.getMovies());
    }

    public static String yearsWithMoreOneWinner(Request request, Response response) {
        YearsWithMoreOneWinner years = new YearsWithMoreOneWinner();
        try {
            years.execute();
        } catch (Exception e) {
            response.status(404);
        }
        return new Gson().toJson(years.getWinnersCounts());
    }

    public static String winnersStudios(Request request, Response response) {
        WinnersStudios winnersStudios = new WinnersStudios();
        try {
            winnersStudios.execute();
        } catch (Exception e) {
            response.status(404);
        }
        return new Gson().toJson(winnersStudios.getStudiosCounts());
    }

    public static String rangesOfAwards(Request request, Response response) {
        HigherAndLowerRangesOfAwards rangesOfAwards =
                new HigherAndLowerRangesOfAwards();
        try {
            rangesOfAwards.execute();
        } catch (Exception e) {
            response.status(404);
        }
        return new Gson().toJson(rangesOfAwards.getRangesOfAwards());
    }
}
