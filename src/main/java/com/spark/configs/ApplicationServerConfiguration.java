package com.spark.configs;

/**
 * Class ApplicationServerConfiguration
 * Responseble to config AppplicationServer
 */
public class ApplicationServerConfiguration {
    public int getPort() {
        Integer port = 5000;
        return port;
    }

    public String getEndpoint() {
        String endpoint = "127.0.0.1";
        return endpoint;
    }

    public String getVersion() {
        String version = "v1";
        return version;
    }
}
