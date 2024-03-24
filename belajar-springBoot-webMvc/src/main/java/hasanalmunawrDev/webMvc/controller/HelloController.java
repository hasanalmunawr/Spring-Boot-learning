package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

   @GetMapping(path = "/hello")
    public void helloWorld(@RequestParam(value = "name", required = false) String name, HttpServletResponse response) throws IOException {
        String responBody = helloService.call(name);
        response.getWriter().print(responBody);
    }

//    @GetMapping(path = "/web/hello")
//    public ModelAndView hello2(@RequestParam(value = "name" , required = false)
//                                  String name) {
//       return new ModelAndView("index", Map.of(
//               "title", "Learn spring",
//               "name", name
//       ));
//    }

//

    @GetMapping(path = "/web/hello")
    @ResponseBody
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {
        if(Objects.isNull(name)){
            return new ModelAndView("redirect:/web/hello?name=Guest");
        }
        return new ModelAndView("hello", Map.of(
                "title", "Belajar View",
                "name", name
        ));
    }
}
