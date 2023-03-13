package tobyspring.helloboot.controller;


//@RestController
public class HelloController {

  //  @GetMapping("/")
  public String printHelloWorld(String name) {
    return "hello" + name;
  }

}
