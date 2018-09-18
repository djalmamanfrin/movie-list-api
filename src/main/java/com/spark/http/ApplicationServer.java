package com.spark.http;

import com.spark.configs.ApplicationServerConfiguration;
import spark.Spark;

import java.util.logging.Logger;

public class ApplicationServer {
    private Logger logger;
    private ApplicationServerConfiguration configuration;

    public ApplicationServer(ApplicationServerConfiguration configuration) {
        this.configuration = configuration;
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

      /**
      * Filtros definidos para aplicação
      */
      try {
        routeMapper.mapFilters();
      } catch (Exception e) {
        e.printStackTrace();
      }

      /**
       * Rotas definidas para a aplicação
       */
      routeMapper.mapRoutes();
    }
}
