package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.model.CreatedPersonRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @PostMapping(path = "/api/persons",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public CreatedPersonRequest createPerson(@RequestBody CreatedPersonRequest personRequest){
        return personRequest;
    }

}
