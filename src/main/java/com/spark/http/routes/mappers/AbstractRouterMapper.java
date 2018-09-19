package com.spark.http.routes.mappers;

import com.spark.http.routes.Router;
import java.util.HashSet;
import java.util.Set;

abstract public class AbstractRouterMapper {
  protected static final String PACKAGES_TO_SCAN = "com.spark.http.routes.*";
  protected Set<Router> routes = new HashSet<>();
  // protected List<String> routes = new ArrayList<>();
  protected String version = "v1";

  public void mapFilters() throws Exception {
      // Rotas das versões cadastradas
      for (Router router : routes) {
          router.mapFilters();
      }
  }

  public void mapRoutes() {
      // Rotas das versões cadastradas
      for (Router router : routes) {
          router.mapRoutes();
      }
  }

//   public List<String> getRoutes() {
//       /**
//        * Rotas das versões cadastradas
//        */
//       for (Router router : routes) {
//
//           List<String> routerRoutes = router.getRoutes();
//
//           if (routerRoutes != null) {
//               routes.addAll(routerRoutes);
//           }
//
//       }
//
//       return routes;
//   }


  abstract Set<Router> getRouters();

  public Integer getIntegerVersion() {
      return Integer.parseInt(version.replace("v", ""));
  }
}
