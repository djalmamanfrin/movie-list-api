package com.spark.http.routes.mappers;

abstract public class AbstractRouterMapper {
  protected static final String PACKAGES_TO_SCAN = "com.rentcars.fortune.application.http.routes.*";
  protected Set<Router> routers = new HashSet<>();
  // protected List<String> routes = new ArrayList<>();
  protected String version = "v1";


  public void mapFilters() throws Exception {
      // Rotas das versões cadastradas
      for (Router router : routers) {
          router.mapFilters();
      }
  }

  public void mapRoutes() {
      // Rotas das versões cadastradas
      for (Router router : routers) {
          router.mapRoutes();
      }
  }

  // public List<String> getRoutes() {
  //     /**
  //      * Rotas das versões cadastradas
  //      */
  //     for (Router router : routers) {
  //
  //         List<String> routerRoutes = router.getRoutes();
  //
  //         if (routerRoutes != null) {
  //             routes.addAll(routerRoutes);
  //         }
  //
  //     }
  //
  //     return routes;
  // }


  abstract Set<Router> getRouters();

  public Integer getIntegerVersion() {
      return Integer.parseInt(version.replace("v", ""));
  }
}
