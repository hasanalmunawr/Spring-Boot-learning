package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.model.CreatedPersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ValidationController {

    @PostMapping(value = "/valid/persons",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CreatedPersonRequest personRequestBody(@RequestBody @Validated CreatedPersonRequest createdPersonRequest) {
        return createdPersonRequest;
    }

    @PostMapping(path = "/valid/form",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String createPerson(@ModelAttribute @Validated CreatedPersonRequest personRequest) {

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
    @PostMapping(path = "/persons/binding",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> createPersonBinding(@ModelAttribute @Validated CreatedPersonRequest personRequest,
                                                                    BindingResult result) {

        if (!result.getAllErrors().isEmpty()) {
            return ResponseEntity.badRequest().body("You send invalid date");
        }

        return ResponseEntity.accepted().body("You date accepted");
    }
}
