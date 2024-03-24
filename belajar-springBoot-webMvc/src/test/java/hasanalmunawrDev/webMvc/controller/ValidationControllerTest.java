package hasanalmunawrDev.webMvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hasanalmunawrDev.webMvc.model.CreatedPersonRequest;
import hasanalmunawrDev.webMvc.model.CreatedSocialMediaRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test() throws Exception {
        CreatedPersonRequest request = new CreatedPersonRequest();
        request.setLastName("almunawar");
        request.setEmail("contoh@gmail.com");
        request.setHobbies(List.of("makan", ",minum"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreatedSocialMediaRequest("ig", "ig.com/hasan"));
        request.getSocialMedias().add(new CreatedSocialMediaRequest("fb", "fb.com/hasan"));

        mockMvc.perform(
                post("/valid/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(request))
        ).andExpectAll(
                status().isBadRequest()
                ,content().string(Matchers.containsString("Error for"))

        );
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(
                post("/valid/form")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("lastName", "kosong")
        ).andExpectAll(
                status().isBadRequest()
                ,content().string(Matchers.containsString("Error for"))
        );
    }

    @Test
    void test3() throws Exception {
        mockMvc.perform(
                post("/persons/binding")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("lastName", "kosong")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid date"))
        );
    }
}