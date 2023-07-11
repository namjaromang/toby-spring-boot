package tobyspring.helloboot;

import static tobyspring.helloboot.HellbootApplication.run;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

  @Bean
  public ServletWebServerFactory servletWebServerFactory() {
    return new TomcatServletWebServerFactory();
  }


  @Bean
  public DispatcherServlet dispatcherServlet() {
    return new DispatcherServlet();
  }


  public static void main(String[] args) {
//    SpringApplication.run(HellbootApplication.class, args);
    run(HellbootApplication.class, args);
  }
}
