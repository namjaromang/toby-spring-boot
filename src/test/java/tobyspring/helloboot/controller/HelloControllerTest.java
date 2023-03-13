package tobyspring.helloboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HelloController.class)
class HelloControllerTest {

  @Autowired
  MockMvc mvc;

  @Test
  void printHelloWorld() throws Exception {
    mvc.perform(get("/"))
        .andExpect(status().isOk());
  }


}