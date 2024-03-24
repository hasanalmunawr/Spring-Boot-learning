package hasanalmunawrDev.webMvc.practice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @PostMapping(path = "/login/users",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String login(@ModelAttribute User user) {
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getEmail());
        return """
                <html lang="en" xmlns:th="https://www.thymeleaf.org">
                <head>
                    <meta charset="UTF-8">
                    <title>Signup result</title>
                </head>
                <body>
                <h1>Signup result</h1>
                <p th:text="'First name:  $firstName" />
                <p th:text="'Last name:  $lastName" />
                <p th:text="'Email: $email" />
                </body>
                </html>""".replace("$firstName", user.getFirstName())
                .replace("$lastName", user.getLastName())
                .replace("$email", user.getEmail());
    }
}
