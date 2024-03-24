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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class JsonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test() throws Exception {
        CreatedPersonRequest request = new CreatedPersonRequest();
        request.setFirstName("hasan");
        request.setLastName("almunawar");
        request.setEmail("contoh@gmail.com");
        request.setPhone("0812345");
        request.setHobbies(List.of("makan", ",minum"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreatedSocialMediaRequest("ig", "ig.com/hasan"));
        request.getSocialMedias().add(new CreatedSocialMediaRequest("fb", "fb.com/hasan"));

        String stringJson = objectMapper.writeValueAsString(request);
        mockMvc.perform(
                post("/api/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(stringJson)
        ).andExpectAll(
                status().isOk(),
                content().json(stringJson)
        );
    }
}