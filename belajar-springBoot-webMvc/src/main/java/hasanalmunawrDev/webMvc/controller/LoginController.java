package hasanalmunawrDev.webMvc.controller;

import hasanalmunawrDev.webMvc.model.CreatedUser;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@Controller
public class LoginController {

    @PostMapping(path = "/users/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public ResponseEntity<String> login(@RequestParam(name = "username") String username,
                                        @RequestParam(name = "password") String password,
                                        HttpServletResponse response,
                                        HttpServletRequest request) {
        if("hasan".equals(username) && "almu".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new CreatedUser("hasan"));

            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/login"); //    it is meaning the cookie just only add for path ''
            response.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("VALID");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT VALID");
    }

    @GetMapping(path = "/users/login-again")
    public ResponseEntity<String> getUser(@CookieValue(name = "username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body("Hello " + username);
    }
}
