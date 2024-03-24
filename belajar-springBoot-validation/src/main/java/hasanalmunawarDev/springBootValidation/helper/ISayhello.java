package hasanalmunawarDev.springBootValidation.helper;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ISayhello {

    String callHer(@NotBlank String name);
}
