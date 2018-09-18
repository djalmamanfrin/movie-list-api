package com.spark.http.routes;

import java.util.List;

public interface Router {
  public void mapFilters() throw Exception;
  public void mapRoutes();
  public List<String> getRoutes();
  public Integer getIntegerVersion();
}
