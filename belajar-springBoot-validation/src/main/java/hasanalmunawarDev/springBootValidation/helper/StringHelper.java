package hasanalmunawarDev.springBootValidation.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {

    public boolean isPalindrom(String value) {
        String reverse = new StringBuilder(value).reverse().toString();
        return value.equals(reverse);
    }
}
