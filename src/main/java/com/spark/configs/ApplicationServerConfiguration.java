package com.spark.configs;

/**
 * Class ApplicationServerConfiguration
 * Responseble to config AppplicationServer
 */
public class ApplicationServerConfiguration {
    protected Integer port = 5000;
    protected String version = "v1";
    protected String endpoint = "127.0.0.1";

    public int getPort() {
        return port;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
