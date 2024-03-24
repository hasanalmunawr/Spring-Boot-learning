package hasanalmunawrDev.webMvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CodeController {

    @DeleteMapping(path = "/users/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable(name = "userId") String userId) {
        // Delete user by id

    }
}
