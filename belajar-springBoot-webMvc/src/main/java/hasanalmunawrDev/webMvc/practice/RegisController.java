package hasanalmunawrDev.webMvc.practice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisController {

    @PostMapping(path = "/regis/students",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String regis(@RequestBody Student student) {

        return "Succes created student by : " + student.getFirstName();
    }
}
