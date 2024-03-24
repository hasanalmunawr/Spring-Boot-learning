package hasanalmunawrDev.RestfulAPI.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.RegisterUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UserResponse;
import hasanalmunawrDev.RestfulAPI.model.WebResponse;
import hasanalmunawrDev.RestfulAPI.repository.UserRepository;
import hasanalmunawrDev.RestfulAPI.security.BCrypt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.support.TransactionOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransactionOperations transactionOperations;

    @BeforeEach
    void setUp() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            userRepository.deleteAll();
        });
    }


    @Test
    void testRegisterSuccess() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("test");
        request.setPassword("rahasia");
        request.setName("Test");

        mockMvc.perform(
                post("/api/users")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            objectMapper.writeValueAsString(result.getResponse().getContentAsString());
        });
    }

    @Test
    void testRegisterFailed() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("");
        request.setPassword("rahasia");
        request.setName("");

        mockMvc.perform(
                post("/api/users")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            objectMapper.writeValueAsString(result.getResponse().getContentAsString());
        });
    }

    @Test
    void testGetUnauthorized() throws Exception{
        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "nothing")
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            Assertions.assertNotNull(response.getError());
        });
    }

    @Test
    void testGetUnauthorizedTokenUnSend() throws Exception{
        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            Assertions.assertNotNull(response.getError());
        });
    }

 @Test
    void testGetSuccess() throws Exception{
     User user = new User();
     user.setUsername("test");
     user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
     user.setName("Test");
     user.setToken("token");
     user.setTokenExpiredAt(System.currentTimeMillis() + 10000000000L);
     userRepository.save(user);

        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            Assertions.assertNull(response.getError());
            assertEquals("test", response.getData().getUsername());
            assertEquals("Test", response.getData().getName());
        });
    }
@Test
    void testGetSuccessTokenExpired() throws Exception{
     User user = new User();
     user.setUsername("test");
     user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
     user.setName("Test");
     user.setToken("token");
     user.setTokenExpiredAt(System.currentTimeMillis() - 10000000);
     userRepository.save(user);

        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            Assertions.assertNotNull(response.getError());
        });
    }

    @Test
    void testUpdateSucces() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
        user.setName("Test");
        user.setToken("token");
        user.setTokenExpiredAt(System.currentTimeMillis() + 10000000000L);
        userRepository.save(user);

        UpdateUserRequest updateRequest = new UpdateUserRequest("Hasan Almu", "hasan123");

        mockMvc.perform(
                patch("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(updateRequest))
                        .header("X-API-TOKEN", "token")

        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
//            WebResponse<UserResponse> response = objectMapper.writeValue(result.getResponse().getContentAsString(), new TypeReference<>() {
//            });
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            Assertions.assertNull(response.getError());
            Assertions.assertEquals("Hasan Almu", response.getData().getName());
            Assertions.assertEquals("test", response.getData().getUsername());
        });
    }
}