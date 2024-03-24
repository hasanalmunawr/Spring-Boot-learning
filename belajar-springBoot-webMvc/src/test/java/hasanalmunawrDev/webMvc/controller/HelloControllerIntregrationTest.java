package hasanalmunawrDev.webMvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntregrationTest {

    @LocalServerPort
    private Integer port;
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void hello() {
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity("http://localhost:" + port + "/hello", String.class);
        String entityBody = responseEntity.getBody();

        Assertions.assertNotNull(entityBody);
        Assertions.assertEquals("hello guest", entityBody);
    }

    @Test
    void helloName() {
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity("http://localhost:" + port + "/hello?name=hasan", String.class);
        String entityBody = responseEntity.getBody();

        Assertions.assertNotNull(entityBody);
        Assertions.assertEquals("hello hasan", entityBody);
    }


}
