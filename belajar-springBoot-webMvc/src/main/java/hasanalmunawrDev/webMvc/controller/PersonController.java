package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.model.CreatedPersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    @PostMapping(path = "/persons/form",
                consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public String createPerson(@ModelAttribute  CreatedPersonRequest personRequest) {

        System.out.println(personRequest.getHobbies());
        System.out.println(personRequest.getSocialMedias());
        return new StringBuilder().append("Succes created ")
                .append(personRequest.getFirstName() + " ")
                .append(personRequest.getLastName() + ", ")
                .append(personRequest.getEmail() + ", ")
                .append(personRequest.getPhone() + ", ")
                .append(personRequest.getAddress().getStreet() + ", ")
                .append(personRequest.getAddress().getCity() + ", ")
                .append(personRequest.getAddress().getCountry() + ", ")
                .append(personRequest.getAddress().getPostalCode()).toString();


    }
}
