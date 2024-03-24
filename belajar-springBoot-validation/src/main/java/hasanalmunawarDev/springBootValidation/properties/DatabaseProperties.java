package hasanalmunawarDev.springBootValidation.properties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties("database")
@NoArgsConstructor
public class DatabaseProperties {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
