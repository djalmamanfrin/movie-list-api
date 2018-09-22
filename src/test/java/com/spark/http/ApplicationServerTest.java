package com.spark.http;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationServerTest {
    @Test
    public void verifyClassExist() {
        try {
            Class.forName("com.spark.http.ApplicationServer");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have a class called ApplicationServer");
        }
    }
}
