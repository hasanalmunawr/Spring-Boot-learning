package hasanalmunawrDev.webMvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    void testHello() {
        Assertions.assertEquals("hello guest", helloService.call(""));
        Assertions.assertEquals("hello hasan", helloService.call("hasan"));
    }
}