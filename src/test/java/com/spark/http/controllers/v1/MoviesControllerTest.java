package com.spark.http.controllers.v1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.spark.AppTest;
import com.spark.models.Movies;
import com.spark.services.rangesOfAwards.RangesOfAwardsDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import spark.Request;
import spark.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoviesControllerTest  extends AppTest {
    private Gson gson;

    @Override
    public void setUp() {
        super.setUp();
        gson = new GsonBuilder().create();
    }

    @Override
    protected HashMap<String, String[]> getQueryParamsMap() {
        HashMap<String, String[]> queryParams = new HashMap<>();
        queryParams.put("year", new String[]{"1980"});
        queryParams.put("uuid", new String[]{"8ec65ac7-b94b-4ae4-a681-fec0474d2d85"});
        return queryParams;
    }

    @Test
    public void verifyReturnMoviesByYearMethod() {
        String moviesByYear = MoviesController.rangesOfAwards(request, response);
        Assert.assertNotNull(moviesByYear);

        List<RangesOfAwardsDto> rangesOfAwards = new ArrayList<>();
        rangesOfAwards.add(gson.fromJson(moviesByYear, RangesOfAwardsDto.class));

    }

    @Test
    public void verifyClassExist() {
        try {
            Class.forName("com.spark.http.controllers.v1.MoviesController");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have a class called MoviesController");
        }
    }
}
