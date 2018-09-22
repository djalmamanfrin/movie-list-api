package com.spark.http.routes.v1;

import com.spark.http.controllers.v1.IndexController;
import com.spark.http.controllers.v1.MoviesController;
import com.spark.http.routes.Router;

import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;

public class ServerRouter implements Router {
    protected String version = "v1";

    @Override
    public void mapRoutes() {
        path("/", () -> get("", IndexController::index));
        path("v1", () -> {
            get("/movies-by-year/:year", MoviesController::moviesByYear);
            get("/delete-movie/:uuid", MoviesController::deleteMovie);
            get("/ranges-of-awards", MoviesController::rangesOfAwards);
            get("/winners-studios", MoviesController::winnersStudios);
            get("/years-with-more-one-winner", MoviesController::yearsWithMoreOneWinner);
        });
        after("/*", (request, response) -> response.type("application/json"));
        notFound((request, response) -> {
            response.type("application/json");
            String message = "{\"message\":\"Not found end-point %s\"}";
            return message.replaceAll("%s", request.url());
        });
    }

    @Override
    public Integer getIntegerVersion() {
        return Integer.parseInt(version.replace("v", ""));
    }
}
