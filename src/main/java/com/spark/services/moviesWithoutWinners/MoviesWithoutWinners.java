package com.spark.services.moviesWithoutWinners;

import com.google.gson.Gson;
import com.spark.models.Movies;
import com.spark.services.MovieService;
import com.spark.utils.exceptions.InvalidArgumentException;
import java.util.List;

/**
 * Class MoviesWithoutWinners
 */
public class MoviesWithoutWinners implements MovieService {
    private String uuid;
    private List<Movies> movies;
    private Movies deleteMovie;

    public MoviesWithoutWinners(String uuid) {
        this.uuid = uuid;
    }//package com.spark.utils;
//
//import com.spark.utils.exceptions.InvalidArgumentException;
//import org.eclipse.jetty.http.HttpStatus;
//import org.eclipse.jetty.http.MimeTypes;
//import spark.Response;
//import spark.ResponseTransformer;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//
//public class JsonResponse implements ResponseTransformer{
//
//    private Exception error;
//    private HashMap<String, Object> result = new HashMap<>();
//    private int statusCode = HttpStatus.OK_200;
//    private Response response;
//
//    public JsonResponse(Response response) {
//        this.response = response;
//    }
//
//    public void setStatusCode(int code) {
//        this.statusCode = code;
//    }
//
//    public JsonResponse setResult(Object object) {
//        this.result.put("body", object);
//        return this;
//    }
//
//    public Response getResponse() {
//        //Headers
//        response.type(MimeTypes.Type.APPLICATION_JSON_UTF_8.toString());
//        this.response.status(this.statusCode);
//        try {
//            this.response.body(transformer.render(result));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return this.response;
//    }
//
//    public String json() {
//        Response response = this.getResponse();
//        return response.body();
//    }
//
//    public JsonResponse setError(Exception error) {
//        this.error = new Exception(error.getMessage(), error);
//        if (error instanceof InvalidArgumentException) {
//            this.error =  error;
//        }
//        return this;
//    }
//
//    @Override
//    public String render(Object o) {
//        return null;
//    }
//}


    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public void execute() throws InvalidArgumentException {
        deleteMovie = movies.stream()
                .filter(this::byUuid)
                .filter(this::byWinner)
                .findFirst()
                .orElse(null);

        if (null == deleteMovie) {
            String message = "The %s muvie doesn't exist em data base. Choice another!";
            throw new InvalidArgumentException(message.replaceAll("%s", uuid));
        }
    }

    private Boolean byUuid(Movies movies) {
        return movies.getUuid().equals(uuid);
    }

    private Boolean byWinner(Movies movies) {
        return !movies.getWinner();
    }

    public String getResponse() {
        return new Gson().toJson(deleteMovie);
    }
}
