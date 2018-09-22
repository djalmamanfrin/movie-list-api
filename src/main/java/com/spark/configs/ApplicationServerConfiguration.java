package com.spark.configs;

/**
 * Class ApplicationServerConfiguration
 * Responseble to config AppplicationServer
 */
public class ApplicationServerConfiguration {
    public int getPort() {
        return 5000;
    }

    public String getEndpoint() {
        return "127.0.0.1";
    }

    public String getVersion() {
        return "v1";
    }
}
