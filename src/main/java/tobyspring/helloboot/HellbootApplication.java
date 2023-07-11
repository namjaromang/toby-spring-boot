package tobyspring.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
      servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext)

          ).addMapping("/*");
    });
    webServer.start();
  }

}
