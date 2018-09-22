package com.spark.utils;

import com.google.gson.Gson;
import com.spark.utils.exceptions.InvalidArgumentException;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.MimeTypes;
import spark.Response;
import spark.ResponseTransformer;
import java.util.HashMap;

public class JsonResponse implements ResponseTransformer {
    private HashMap<String, Object> result = new HashMap<>();
    private int statusCode = HttpStatus.OK_200;
    private Response response;

    public JsonResponse(Response response) {
        this.response = response;
    }

    public void setStatusCode(int code) {
        this.statusCode = code;
    }

    public void setResponse(Object object) {
        result.put("body", object);
    }

    private Response getResponse() {
        //Headers
        response.type(MimeTypes.Type.APPLICATION_JSON_UTF_8.toString());
        response.status(this.statusCode);
        response.body(render(result));
        return response;
    }

    public String json() {
        Response response = this.getResponse();
        return response.body();
    }

    public void setError(Exception exception) {
        result.put("error", new Exception(exception.getMessage()));
        if (exception instanceof InvalidArgumentException) {
            result.put("error", new InvalidArgumentException(exception.getMessage()));
        }
    }

    @Override
    public String render(Object object) {
        return new Gson().toJson(object);
    }
}
