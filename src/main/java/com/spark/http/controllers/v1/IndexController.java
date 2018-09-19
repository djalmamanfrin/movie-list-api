package com.spark.http.controllers.v1;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

/**
 * Class IndexController
 *
 * Class responseble to test api endpoint
 */
public class IndexController {

  public static void index(Request request, Response response) {
      String url = "v2" + request.url();
      response.redirect(url);
  }

  public static String ping(Request request, Response response) {
      return new Gson().toJson("Movie List API Version 1");
  }
}
