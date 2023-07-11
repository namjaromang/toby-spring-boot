package tobyspring.helloboot;


import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@RestController
@RestController
public class HelloController {

  private final HelloInterface helloInterface;

  public HelloController(HelloInterface helloInterface) {
    this.helloInterface = helloInterface;
  }


  @GetMapping("/hello")
  @ResponseBody
  public String printHelloWorld(String name) {
    return helloInterface.sayHello(Objects.requireNonNull(name));
  }

}
