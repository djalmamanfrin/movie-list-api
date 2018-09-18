package com.spark.http.routes;

import com.spark.http.routes.mappers.AbstractRouterMapper;
import com.spark.http.routes.mappers.AllVersionsRouterMapper;
import com.spark.http.routes.mappers.VersionedRouterMapper;

public class RouteManager {
  private Boolean allVersion = true;
  private String version;

  public RouteManager(String version) {
      allVersion = false;
        this.version = version;
  }

  public AbstractRouterMapper getMapper() {
      AbstractRouterMapper mapper = new VersionedRouterMapper(version);
      if (allVersion) {
          mapper = new AllVersionsRouterMapper();
      }
      return mapper;
  }
}
