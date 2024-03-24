package hasanalmunawarDev.springBootValidation;

import hasanalmunawarDev.springBootValidation.helper.SayHello;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SayHelloTest {

    @Autowired
    private SayHello sayHello;

    @Test
    void testValid() {
        Assertions.assertEquals("Hello Deva", sayHello.callHer("Deva"));
    }

    @Test
    void testNoValid() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            sayHello.callHer("");
        });
    }
}
