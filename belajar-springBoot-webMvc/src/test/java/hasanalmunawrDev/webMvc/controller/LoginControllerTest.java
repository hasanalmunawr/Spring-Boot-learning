package hasanalmunawrDev.webMvc.controller;

import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValid() throws Exception {
        mockMvc.perform(
                post("/users/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "hasan")
                        .param("password", "almu")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("VALID")),
                cookie().value("username", "hasan")
        );
    }

    @Test
    void testNotValid() throws Exception {
        mockMvc.perform(
                post("/users/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "hasan")
                        .param("password", "salah")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("NOT VALID"))
        );
    }

    @Test
    void testLoginAgain() throws Exception {
        mockMvc.perform(
                get("/users/login-again")
                        .cookie(new Cookie("username", "hasan"))
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello hasan"))
        );
    }
}