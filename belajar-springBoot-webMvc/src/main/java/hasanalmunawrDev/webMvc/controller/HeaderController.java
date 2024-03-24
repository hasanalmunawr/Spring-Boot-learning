package hasanalmunawrDev.webMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/call")
    @ResponseBody
    public String header(@RequestHeader(name = "TOKEN") String token){
        if(token.equals("hasan")) {
            return "VALID";
        } else {
            return "Not VALID";
        }
    }
}
