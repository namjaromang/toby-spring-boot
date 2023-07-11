package tobyspring.helloboot;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements HelloInterface {

  public String sayHello(String name) {
    return "hello " + name;
  }

}
