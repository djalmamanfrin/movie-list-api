package com.spark.http.controllers.v1;

import com.rentcars.fortune.application.http.response.ApiResponse;
import spark.Request;
import spark.Response;

/**
 * Class IndexController
 *
 * Class responseble to test api endpoint
 */
public class IndexController {

  public static String index(Request request, Response response) {

      ApiResponse apiResponse = new ApiResponse(response);
      apiResponse.setResult("version 1");
      return apiResponse.json();
  }

  public static String ping(Request request, Response response) {

      ApiResponse apiResponse = new ApiResponse(response);
      apiResponse.setResult("version 1");
      return apiResponse.json();
  }
}
