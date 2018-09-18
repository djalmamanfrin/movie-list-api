package com.spark.http.routes.v1;

import com.spark.http.controllers.v1.IndexController;
import com.spark.http.routes.Router;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;

public class ServerRouter implements Router {
    protected String version = "v1";
    private List<String> routes = new ArrayList<>();

    @Override
    public void mapFilters() throws Exception {
        // before("/*", ""); Before validation
    }

    @Override
    public void mapRoutes() {
        path("/", () -> {
            get("", IndexController::index);
            get("/ping", IndexController::ping);
        });
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
