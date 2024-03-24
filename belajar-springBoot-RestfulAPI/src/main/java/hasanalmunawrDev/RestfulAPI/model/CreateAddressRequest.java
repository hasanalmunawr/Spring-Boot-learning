package hasanalmunawrDev.RestfulAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressRequest {

    @JsonIgnore
    @NotBlank
    private String Contactid;

    private String street;

    private String city;

    private String province;

    @NotBlank
    private String country;

    @NotBlank
    private String postalCode;
}
