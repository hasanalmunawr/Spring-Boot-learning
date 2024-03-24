package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.model.Partner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PatnerController {

    @GetMapping(path = "/patner/current")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getPatner(Partner patner) {

        return   patner.getId() + " " + patner.getName();
    }

    @GetMapping("/partner/current")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getPartner(Partner partner) {
        return partner.getId() + " : " + partner.getName();
    }

}
