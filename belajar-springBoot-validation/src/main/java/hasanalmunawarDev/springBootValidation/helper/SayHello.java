package hasanalmunawarDev.springBootValidation.helper;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class SayHello implements ISayhello {

    public String callHer(@NotBlank String name) {
        return "Hello " + name;
    }
}
