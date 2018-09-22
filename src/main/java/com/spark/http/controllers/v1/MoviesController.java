package com.spark.http.controllers.v1;

import com.spark.services.MovieListManager;
import com.spark.services.moviesWithoutWinners.MoviesWithoutWinners;
import com.spark.services.rangesOfAwards.HigherAndLowerRangesOfAwards;
import com.spark.services.winnersByYear.WinnersByYear;
import com.spark.services.winnersStudios.WinnersStudios;
import com.spark.services.yearsWithWinners.YearsWithMoreOneWinner;
import com.spark.utils.JsonResponse;
import spark.Request;
import spark.Response;

public class MoviesController {
    public static String moviesByYear(Request request, Response response) {
        String year = request.params("year");
        JsonResponse jsonResponse = new JsonResponse(response);
        MovieListManager manager = new MovieListManager(new WinnersByYear(year));
        try {
            manager.execute();
            jsonResponse.setResponse(manager.getResponse());
        } catch (Exception exception) {
            jsonResponse.setStatusCode(404);
            jsonResponse.setError(exception);
        }
        return jsonResponse.json();
    }

    public static String yearsWithMoreOneWinner(Request request, Response response) {
        JsonResponse jsonResponse = new JsonResponse(response);
        MovieListManager manager = new MovieListManager(new YearsWithMoreOneWinner());
        try {
            manager.execute();
            jsonResponse.setResponse(manager.getResponse());
        } catch (Exception exception) {
            jsonResponse.setStatusCode(404);
            jsonResponse.setError(exception);
        }
        return jsonResponse.json();
    }

    public static String winnersStudios(Request request, Response response) {
        JsonResponse jsonResponse = new JsonResponse(response);
        MovieListManager manager = new MovieListManager(new WinnersStudios());
        try {
            manager.execute();
            jsonResponse.setResponse(manager.getResponse());
        } catch (Exception exception) {
            jsonResponse.setStatusCode(404);
            jsonResponse.setError(exception);
        }
        return jsonResponse.json();
    }

    public static String rangesOfAwards(Request request, Response response) {
        JsonResponse jsonResponse = new JsonResponse(response);
        MovieListManager manager = new MovieListManager(new HigherAndLowerRangesOfAwards());
        try {
            manager.execute();
            jsonResponse.setResponse(manager.getResponse());
        } catch (Exception exception) {
            jsonResponse.setStatusCode(404);
            jsonResponse.setError(exception);
        }
        return jsonResponse.json();
    }

    public static String deleteMovie(Request request, Response response) {
        String uuid = request.params("uuid");
        JsonResponse jsonResponse = new JsonResponse(response);
        MovieListManager manager = new MovieListManager(new MoviesWithoutWinners(uuid));
        try {
            manager.execute();
            jsonResponse.setResponse(manager.getResponse());
        } catch (Exception exception) {
            jsonResponse.setStatusCode(404);
            jsonResponse.setError(exception);
        }
        return jsonResponse.json();
    }
}
