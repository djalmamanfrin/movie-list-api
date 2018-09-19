package com.spark.http.routes.v2;

import com.spark.http.controllers.v2.IndexController;
import com.spark.http.routes.Router;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.get;

/**
 * Class ServerRouter
 * V2 Routes
 */
public class ServerRouter implements Router {

    protected String version = "v2";
    private List<String> routes = new ArrayList<>();

    @Override
    public void mapFilters() throws Exception {

        get("/" + version + "/ping", IndexController::ping);
        routes.add("GET /" + version + "/ping");
    }

    @Override
    public void mapRoutes() {

    }

    @Override
    public List<String> getRoutes() {
        return routes;
    }

    @Override
    public Integer getIntegerVersion() {
        return Integer.parseInt(version.replace("v", ""));
    }
}
