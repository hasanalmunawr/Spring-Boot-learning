package hasanalmunawrDev.webMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @GetMapping(path = "/orders/{brandId}/products/{productId}")
    @ResponseBody
    public String order(@PathVariable(name = "brandId") String brandId,@PathVariable(name = "productId") String productId) {
        return "Order brand : " + brandId + ", product : " + productId;
    }
}
