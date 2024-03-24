package hasanalmunawrDev.webMvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FormControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPerson() throws Exception {
        mockMvc.perform(
                post("/form/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "hasan")
                        .param("birthDate", "2004-07-23")
                        .param("address", "Jambi")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Created a person Name : hasan, BirthDate : 2004-07-23, Address : Jambi"))
        );
    }





    @Test
    void testConsum() throws Exception {
        mockMvc.perform(
                post("/form/hello")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .queryParam("name", "hasan")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello hasan"))
        );
    }

    @Test
    void testProduce() throws Exception {
        mockMvc.perform(
                post("/form/call")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .queryParam("name", "hasan")
        ).andExpectAll(
                status().isOk(),
                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                content().string(Matchers.containsString("Hello hasan"))
        );
    }
}