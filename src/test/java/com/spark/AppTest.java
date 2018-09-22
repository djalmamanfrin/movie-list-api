package com.spark;

import com.spark.http.ApplicationServer;
import com.spark.services.MovieListManager;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.isA;

/**
 * Container to initialize the Application.
 */
abstract public class AppTest
{
    @Mock
    protected Request request;

    @Mock
    protected Response response;

    public void setUp() {
        initializeContainer();
    }

    private void initializeContainer() {
        new ApplicationServer();
        MovieListManager.run();
    }

    @Before
    public void init() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HashMap<String, String[]> queryParams = getQueryParamsMap();
        request = Mockito.mock(Request.class);
        response = Mockito.mock(Response.class);

        Constructor<QueryParamsMap> constructor = QueryParamsMap.class.getDeclaredConstructor(Map.class);
        constructor.setAccessible(true);
        QueryParamsMap queryParamsMap = constructor.newInstance(queryParams);

        Mockito.when(request.queryMap(Mockito.anyString())).thenReturn(queryParamsMap);
        Mockito.when(request.queryMap()).thenReturn(queryParamsMap);

        Mockito.doCallRealMethod().when(response).body();
        Mockito.doCallRealMethod().when(response).body(isA(String.class));

    }

    protected abstract HashMap<String, String[]> getQueryParamsMap();
}
