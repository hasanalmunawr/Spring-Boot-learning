package hasanalmunawrDev.webMvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void helloName() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "hasan")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello hasan"))

        );
    }

    @Test
    void helloPost() throws Exception {
        mockMvc.perform(
                post("/hello").queryParam("name", "hasan")
        ).andExpectAll(
                status().isMethodNotAllowed()
        );
    }

//    @Test
//    void helloHtml() throws Exception {
//
//        mockMvc.perform(
//                get("/web/hello")
//                        .queryParam("name", "hasan")
//        ).andExpectAll(
//                status().isOk(),
//                content().string(Matchers.containsString("Belajar view")),
//                content().string(Matchers.containsString("hello hasan"))
//        );
//    }


    @Test
    void testRedirect() throws Exception {
        mockMvc.perform(
                get("/web/hello")
        ).andExpectAll(
                status().is3xxRedirection()
        );
    }
}