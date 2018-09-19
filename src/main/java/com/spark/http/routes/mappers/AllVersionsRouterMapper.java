package com.spark.http.routes.mappers;

import com.spark.http.routes.Router;
import org.reflections.Reflections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AllVersionsRouterMapper extends AbstractRouterMapper {

  public AllVersionsRouterMapper() {
      // Limita a versão das rotas a serem processadas
      routes = getRouters();
      System.out.println("Running mapper " + this.getClass().getName());
  }

  public Set<Router> getRouters() {
      routes = new HashSet<>();
      Reflections reflections = new Reflections(PACKAGES_TO_SCAN);
      Set<Class<? extends Router>> routesClasses = reflections.getSubTypesOf(Router.class);
      Iterator<Class<? extends Router>> iterator = routesClasses.iterator();

      while (iterator.hasNext()) {
          Class routerClass = iterator.next();
          System.out.println(routerClass.getName());

          try {
              Router router = (Router) routerClass.newInstance();
              // Só mapeia versoes conforme solicitado ou anteriores, futuras versẽos só via programação
              routes.add(router);

          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return routes;
  }
}
