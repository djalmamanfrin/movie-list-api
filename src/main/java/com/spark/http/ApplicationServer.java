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
    }

    private void config() {
        Spark.port(configuration.getPort());
        Spark.ipAddress(configuration.getEndpoint());
    }

    private void routes() {

    }
}
