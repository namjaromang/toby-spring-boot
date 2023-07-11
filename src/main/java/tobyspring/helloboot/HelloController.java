package tobyspring.helloboot;


import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@RestController
@RequestMapping("/")
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
