package hasanalmunawarDev.springBootValidation.data;

import hasanalmunawarDev.springBootValidation.validation.Palindrome;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Foo {

    @Palindrome
    private String barr;
}
