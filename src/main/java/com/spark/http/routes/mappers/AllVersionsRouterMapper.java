package com.spark.http.routes.mappers;

public class AllVersionsRouterMapper extends AbstractRouterMapper {

  public AllVersionsRouterMapper() {
      // Limita a versão das rotas a serem processadas
      routers = getRouters();
      logger.info("Running mapper " + this.getClass().getName());
  }

  public Set<Router> getRouters() {
      routers = new HashSet<>();
      Reflections reflections = new Reflections(PACKAGES_TO_SCAN);
      Set<Class<? extends Router>> routersClasses = reflections.getSubTypesOf(Router.class);
      Iterator<Class<? extends Router>> iterator = routersClasses.iterator();

      while (iterator.hasNext()) {
          Class routerClass = iterator.next();
          System.out.println(routerClass.getName());

          try {
              Router router = (Router) routerClass.newInstance();
              // Só mapeia versoes conforme solicitado ou anteriores, futuras versẽos só via programação
              routers.add(router);

          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return routers;
  }
}
