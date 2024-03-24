package hasanalmunawrDev.webMvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/form/person",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createPerson1(@RequestParam(name = "name") String name,
                                @RequestParam(name = "birthDate") Date birthDate,
                                @RequestParam(name = "address") String address) {
        return "Created a person Name : " + name + ", BirthDate : " + dateFormat.format(birthDate) + ", Address : " +address;
    }
//@PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//@ResponseBody
//public String createPerson(
//        @RequestParam(name = "name") String name,
//        @RequestParam(name = "birthDate") Date birthDate,
//        @RequestParam(name = "address") String address
//) {
//    return "Success create Person with name : " + name +
//            ", birthDate : " + dateFormat.format(birthDate) +
//            ", address : " + address;
//}


    @ResponseBody
    @PostMapping(path = "/form/call",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String call(@RequestParam(name = "name") String name) {
        return  """
                <html>
                <body>
                <h1>Hello $name</h1>
                </body>
                </html>
                """.replace("$name", name);
    }

    @ResponseBody
    @PostMapping(path = "/form/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String hello(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }
}
