package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class HellbootApplication {

  @Bean
  public HelloController helloController(HelloInterface helloInterface) {
    return new HelloController(helloInterface);
  }

  @Bean
  public HelloInterface helloService() {
    return new HelloService();
  }


  public static void main(String[] args) {
//    SpringApplication.run(HellbootApplication.class, args);
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
      @Override
      protected void onRefresh() {
        super.onRefresh();
        TomcatServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
          servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this)
          ).addMapping("/*");
        });
        webServer.start();
      }
    };
    applicationContext.register(HellbootApplication.class);
    applicationContext.refresh();
  }

}
