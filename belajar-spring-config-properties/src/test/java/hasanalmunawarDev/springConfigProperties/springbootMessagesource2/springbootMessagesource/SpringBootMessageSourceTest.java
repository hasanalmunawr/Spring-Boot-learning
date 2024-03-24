package hasanalmunawarDev.springConfigProperties.springbootMessagesource2.springbootMessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest
public class SpringBootMessageSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    void testHasan() {
       Assertions.assertEquals("Hello hasan", messageSource.getMessage("hello",new Object[]{"hasan"}, Locale.ENGLISH));
       Assertions.assertEquals("Halo hasan", messageSource.getMessage("hello", new Object[]{"hasan"}, new Locale("id", "ID")));
    }

    @Configuration
    public static class messageConfig{

        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource  = new ResourceBundleMessageSource();
            messageSource.setBasenames("messages");
            return messageSource;
        }
    }

}
