package tobyspring.helloboot;


import java.util.Objects;


//@RestController
public class HelloController {

  private final HelloInterface helloInterface;

  public HelloController(HelloInterface helloInterface) {
    this.helloInterface = helloInterface;
  }


  //  @GetMapping("/")
  public String printHelloWorld(String name) {
    return helloInterface.sayHello(Objects.requireNonNull(name));
  }

}
