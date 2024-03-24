package hasanalmunawrDev.webMvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedSocialMediaRequest {

    private String name;
    private String link;
}
