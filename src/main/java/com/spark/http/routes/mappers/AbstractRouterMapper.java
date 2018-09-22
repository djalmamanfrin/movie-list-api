package com.spark.http.routes.mappers;

import com.spark.http.routes.Router;
import java.util.HashSet;
import java.util.Set;

abstract public class AbstractRouterMapper {
  protected static final String PACKAGES_TO_SCAN = "com.spark.http.routes.*";
  protected Set<Router> routes = new HashSet<>();
  protected String version = "v1";

  public void mapRoutes() {
      // Rotas das versões cadastradas
      for (Router router : routes) {
          router.mapRoutes();
      }
  }

  abstract Set<Router> getRouters();

  public Integer getIntegerVersion() {
      return Integer.parseInt(version.replace("v", ""));
  }
}
