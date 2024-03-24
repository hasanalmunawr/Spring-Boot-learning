package hasanalmunawarDev.Aop;

import hasanalmunawarDev.Aop.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void test() {
        Assertions.assertEquals("Hello hasan", helloService.hello("hasan"));
        Assertions.assertEquals("Bye hasan", helloService.bye("hasan"));

        Assertions.assertEquals("Hello my name is hasan almunawar", helloService.introduction("hasan", "almunawar"));

        helloService.test();
    }
}
