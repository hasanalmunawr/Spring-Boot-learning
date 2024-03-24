package hasanalmunawrDev.webMvc.controller;

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
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
        mockMvc.perform(
                post("/persons/form")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "hasan")
                        .param("lastName", "almunawar")
                        .param("email", "contoh@.gmail")
                        .param("phone", "081235631")
                        .param("address.street", "jalan tanah")
                        .param("address.city", "Jambi")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "3214")
                        .param("hobbies[0]", "coding")
                        .param("hobbies[1]", "reading")
                        .param("hobbies[2]", "motong")
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].link", "facebook.com/hasan")
                        .param("socialMedias[1].name", "telegram")
                        .param("socialMedias[1].link", "telegram.com/hasan")

        ).andExpectAll(
                status().isAccepted(),
                content().string(Matchers.containsString("Succes created hasan almunawar, contoh@.gmail, 081235631, jalan tanah, Jambi, Indonesia, 3214"))

        );
    }
}