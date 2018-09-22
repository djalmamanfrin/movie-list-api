package com.spark.http.controllers.v1;

import com.spark.AppTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spark.Request;
import spark.Response;
import java.util.HashMap;

public class IndexControllerTest extends AppTest {
    @Mock
    private Request request;

    @Mock
    private Response response;

    @Override
    public void setUp() {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    @Override
    protected HashMap<String, String[]> getQueryParamsMap() {
        return null;
    }

    @Test
    public void verifyReturnIndexMethod() {
        Object index = IndexController.index(request, response);
        Assert.assertNotNull(index);
    }

    @Test
    public void verifyClassExist() {
        try {
            Class.forName("com.spark.http.controllers.v1");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have a class called IndexController");
        }
    }
}
