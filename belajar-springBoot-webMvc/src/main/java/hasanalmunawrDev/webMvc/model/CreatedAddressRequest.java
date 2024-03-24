package hasanalmunawrDev.webMvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedAddressRequest {

    private String street;
    private String city;
    private String country;
    private String postalCode;

}
