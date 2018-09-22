package com.spark.configs;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ApplicationServerConfigurationTest {
    @Test
    public void verifyClassExist() {
        try {
            Class.forName("com.spark.configs.ApplicationServerConfiguration");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have a class called ApplicationServerConfiguration");
        }
    }

    @Test
    public void thePortMustBe5000() {
        Integer port = new ApplicationServerConfiguration().getPort();
        assertEquals(5000, new ApplicationServerConfiguration().getPort());
    }

    @Test
    public void theEndPointMustbeLocalHost() {
        String endpoint = new ApplicationServerConfiguration().getEndpoint();
        assertEquals("127.0.0.1", endpoint);
    }

    @Test
    public void theCurrentRouteMustBeV1() {
        String version = new ApplicationServerConfiguration().getVersion();
        assertEquals("v1", version);
    }
}
