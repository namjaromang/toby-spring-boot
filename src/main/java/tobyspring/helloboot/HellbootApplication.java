package tobyspring.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import tobyspring.helloboot.controller.HelloController;

@SpringBootApplication
public class HellbootApplication {

  public static void main(String[] args) {
//    SpringApplication.run(HellbootApplication.class, args);
    TomcatServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
    WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
      HelloController helloController = new HelloController();
      servletContext.addServlet("hello", new HttpServlet() {
            @Override
            public void service(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
              if (req.getRequestURI()
                  .equals("/hello") && req.getMethod()
                  .equals(HttpMethod.GET.name())) {
                String name = req.getParameter("name");
                String ret = helloController.printHelloWorld(name);

                res.setStatus(HttpStatus.OK.value());
                res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                res.getWriter()
                    .println(ret);
              } else if (req.getRequestURI()
                  .equals("/user")) {
                //
              } else {
                res.setStatus(HttpStatus.NOT_FOUND.value());
              }


            }
          })
          .addMapping("/hello");
    });
    webServer.start();
  }

}
