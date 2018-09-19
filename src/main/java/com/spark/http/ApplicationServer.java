package com.spark.http;

import com.spark.configs.ApplicationServerConfiguration;
import com.spark.http.routes.RouteManager;
import com.spark.http.routes.mappers.AbstractRouterMapper;
import spark.Spark;

import java.util.logging.Logger;

public class ApplicationServer {
    private ApplicationServerConfiguration configuration;

    public ApplicationServer() {
        this.configuration = new ApplicationServerConfiguration();
        config();
        routes();
    }

    private void config() {
        Spark.port(configuration.getPort());
        Spark.ipAddress(configuration.getEndpoint());
    }

    private void routes() {
      String version = configuration.getVersion();
      AbstractRouterMapper routeMapper = new RouteManager(version).getMapper();

      // Filtros definidos para aplicação
//      try {
//        routeMapper.mapFilters();
//      } catch (Exception e) {
//        e.printStackTrace();
//      }

      // Rotas definidas para a aplicação
      routeMapper.mapRoutes();
    }
}
