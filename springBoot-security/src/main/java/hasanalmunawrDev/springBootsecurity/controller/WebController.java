package hasanalmunawrDev.springBootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(path = "/")
    public String sayHello(){
        return "<h1>Hello From My API</h1>";
    }

}
