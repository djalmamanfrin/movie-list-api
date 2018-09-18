package com.spark.http.routes.mappers;

import com.spark.http.routes.Router;
import org.reflections.Reflections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VersionedRouterMapper extends AbstractRouterMapper {

  public VersionedRouterMapper(String version) {
      this.version = version;
      routes = getRouters();
      System.out.println("Running mapper " + this.getClass().getName());
  }

  public Set<Router> getRouters() {

      routes = new HashSet<>();
      Integer intVersion = getIntegerVersion(version);
      Reflections reflections = new Reflections(PACKAGES_TO_SCAN);
      Set<Class<? extends Router>> routesClasses = reflections.getSubTypesOf(Router.class);
      Iterator<Class<? extends Router>> iterator = routesClasses.iterator();

      while (iterator.hasNext()) {
          Class routerClass = iterator.next();
          System.out.println(routerClass.getName());

          // Ignora este router
          if (routerClass.equals(this.getClass())) continue;

          try {
              Router router = (Router) routerClass.newInstance();
              Integer routerVersion = router.getIntegerVersion();

              //Só mapeia versoes conforme solicitado ou anteriores, futuras versẽos só via programação
              if (routerVersion <= intVersion) {
                  routes.add(router);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return routes;
  }

  private Integer getIntegerVersion(String version) {
      return Integer.parseInt(version.replace("v", ""));
  }
}
