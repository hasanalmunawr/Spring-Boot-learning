package hasanalmunawarDev.springBootValidation.messageIndonesian;

import hasanalmunawarDev.springBootValidation.data.Foo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.Set;

@SpringBootTest
public class MessageTest {

    @Autowired
    private Validator validator;

    @Autowired
    private MessageSource messageSource;

    @Test
    void testEnglish() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("hasan"));
        String message = constraintViolations.stream().findFirst().get().getMessage();
        Assertions.assertEquals("It is not palindrome", message);
    }

     @Test
    void testIndonesian() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("hasan"));
        String message = constraintViolations.stream().findFirst().get().getMessage();
        Assertions.assertEquals("It is not palindrome", message);

         String message1 = messageSource.getMessage("Palindrome.message", null, new Locale("id", "ID"));
         Assertions.assertEquals("Ini Bukan Palindrome", message1);
    }



}
