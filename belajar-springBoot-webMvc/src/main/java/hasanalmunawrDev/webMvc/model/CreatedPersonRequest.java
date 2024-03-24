package hasanalmunawrDev.webMvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPersonRequest {

    @NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    private CreatedAddressRequest address;

    private List<String> hobbies;

    private List<CreatedSocialMediaRequest> socialMedias;
}
