package com.spark.http.controllers.v2;

import spark.Request;
import spark.Response;

/**
 * Class IndexController
 *
 * Class responseble to test api endpoint
 */
public class IndexController {

    public static String index(Request request, Response response) {
        return "{\"message\":\"Movie List API Version 1\"}";
    }
}
