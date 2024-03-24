package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.model.CreatedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller()
public class UserController1 {


    @GetMapping(path = "/user/current")
    @ResponseBody
    public String getUser2(@SessionAttribute(name = "user") CreatedUser user) {
        return "Hello " + user.getUser();
    }
}
