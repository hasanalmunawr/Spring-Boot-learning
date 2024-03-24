package hasanalmunawarDev.springBootValidation;

import hasanalmunawarDev.springBootValidation.data.Foo;
import hasanalmunawarDev.springBootValidation.helper.StringHelper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.Set;

@SpringBootTest()
@Slf4j
public class CostumValidatorTest {

    @Autowired
    private StringHelper stringHelper;

    @Autowired
    private Validator validator;

    @Autowired
    private MessageSource messageSource;


    @Test
    void testNoValid() {
        Set<ConstraintViolation<Foo>> hasan = validator.validate(new Foo("hasan"));
        Assertions.assertFalse(hasan.isEmpty());
        Foo foo = new Foo("hasan");
        Assertions.assertFalse(stringHelper.isPalindrom(foo.getBarr()));
    }

    @Test
    void testValid() {
        Set<ConstraintViolation<Foo>> hasan = validator.validate(new Foo("nawan"));
        Assertions.assertTrue(hasan.isEmpty());

        Foo foo = new Foo("nawan");
        Assertions.assertTrue(stringHelper.isPalindrom(foo.getBarr()));
    }

    @Test
    void testPalindromeMessage() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("hasan"));
        String message = constraintViolations.stream().findFirst().get().getMessage();
        log.info(message);
        Assertions.assertEquals("This not palindrome", message);
    }



}
