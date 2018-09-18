package com.spark.http.routes;

public class RouteManager {
  private Boolean versioned = false;
  private String version;

  public RouteManager(version) {
        this.versioned = true;
        version = routesVersion;
  }

  public AbstractRouterMapper getMapper() {

      AbstractRouterMapper mapper = new VersionedRouterMapper(version);
      if (!versioned) {
          mapper = new AllVersionsRouterMapper();
      }

      return mapper;
  }
}
