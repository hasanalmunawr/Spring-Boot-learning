package hasanalmunawrDev.RestfulAPI.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.LoginUserRequest;
import hasanalmunawrDev.RestfulAPI.model.WebResponse;
import hasanalmunawrDev.RestfulAPI.repository.UserRepository;
import hasanalmunawrDev.RestfulAPI.security.BCrypt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void loginSucces() throws Exception {
        User user = new User();
        user.setUsername("yuser");
        user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
        user.setName("namaku");
        userRepository.save(user);

        LoginUserRequest request = new LoginUserRequest("yuser","rahasia");
        String loginJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson)
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            objectMapper.writeValueAsString(result.getResponse().getContentAsString());
        });
    }
    @Test
    void loginFailedUsernamNotFound() throws Exception {
        User user = new User();
        user.setUsername("yuser");
        user.setPassword("rahasia");
        user.setName("namaku");
        userRepository.save(user);

        LoginUserRequest request = new LoginUserRequest("ya", BCrypt.hashpw("rahasia", BCrypt.gensalt()));
        String loginJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson)
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            objectMapper.writeValueAsString(result.getResponse().getContentAsString());
        });
    }



    @Test
    void loginFailedNotFound() throws Exception {
        User user = new User();
        user.setUsername("yuser");
        user.setPassword("rahasia");
        user.setName("namaku");
//        userRepository.save(user);

        String json = objectMapper.writeValueAsString(user);

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            objectMapper.writeValueAsString(result.getResponse().getContentAsString());
        });
    }

    @Test
    void testLogout() throws Exception{
        User user = new User();
        user.setUsername("test");
        user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
        user.setName("Test");
        user.setToken("token");
        user.setTokenExpiredAt(System.currentTimeMillis() + 10000000000L);
        userRepository.save(user);

        mockMvc.perform(
                delete("/api/auth/logout")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());
            assertEquals("OK", response.getData());

            User userDb = userRepository.findById("test").orElse(null);
            assertNotNull(userDb);
            assertNull(userDb.getTokenExpiredAt());
            assertNull(userDb.getToken());
        });
    }

    @Test
    void logoutFailed() throws Exception {
        mockMvc.perform(
                delete("/api/auth/logout")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getError());
        });
    }
}