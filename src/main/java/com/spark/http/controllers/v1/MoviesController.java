package com.spark.http.controllers.v1;

import com.google.gson.Gson;
import com.spark.serives.WinnersByYear;
import com.spark.utils.JsonResponse;
import spark.Request;
import spark.Response;

public class MoviesController {
    public static String moviesByYear(Request request, Response response) {
        String year = request.queryParams("year");
        WinnersByYear winners = new WinnersByYear(year);
        try {
            winners.execute();
        } catch (Exception e) {
            response.status(404);
//            json.render();
        }
        return new Gson().toJson(winners.getResponse());
    }
}
