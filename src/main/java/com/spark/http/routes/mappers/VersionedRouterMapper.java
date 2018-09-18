package com.spark.http.routes.mappers;

public class VersionedRouterMapper extends AbstractRouterMapper {

  public VersionedRouterMapper(Logger logger, ApplicationRoutesVersion routesVersion) {
      version = routesVersion.getVersion();
      routers = getRouters();
      logger.info("Running mapper " + this.getClass().getName());
  }

  public Set<Router> getRouters() {

      routers = new HashSet<>();
      Integer intVersion = getIntegerVersion(version);
      Reflections reflections = new Reflections(PACKAGES_TO_SCAN);
      Set<Class<? extends Router>> routersClasses = reflections.getSubTypesOf(Router.class);
      Iterator<Class<? extends Router>> iterator = routersClasses.iterator();

      while (iterator.hasNext()) {
          Class routerClass = iterator.next();
          logger.info(routerClass.getName());

          // Ignora este router
          if (routerClass.equals(this.getClass())) continue;

          try {
              Router router = (Router) routerClass.newInstance();
              Integer routerVersion = router.getIntegerVersion();

              //Só mapeia versoes conforme solicitado ou anteriores, futuras versẽos só via programação
              if (routerVersion <= intVersion) {
                  routers.add(router);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return routers;
  }

  private Integer getIntegerVersion(String version) {
      return Integer.parseInt(version.replace("v", ""));
  }
}
