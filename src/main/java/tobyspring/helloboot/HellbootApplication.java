package tobyspring.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class HellbootApplication {

  public static void main(String[] args) {
//    SpringApplication.run(HellbootApplication.class, args);
    GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
    applicationContext.registerBean(HelloController.class);
    applicationContext.registerBean(HelloService.class);
    applicationContext.refresh();

    TomcatServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
    WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
      servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext))
          .addMapping("/hello");
    });
    webServer.start();
  }

}
