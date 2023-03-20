package tobyspring.helloboot;

public class HelloService implements HelloInterface {

  public String sayHello(String name) {
    return "hello " + name;
  }

}
