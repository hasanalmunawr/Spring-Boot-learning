package hasanalmunawarDev.springConfigProperties.profileFile;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileFileTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ProfileFileTest {

   @Autowired
    private TestApplication.ProfileProperties properties;


    @Test
    void test() {
        Assertions.assertEquals("Default", properties.getDefaultFile());
        Assertions.assertEquals("Production", properties.getProductionFile());
        Assertions.assertEquals("Test", properties.getTestFile());
    }
    @SpringBootApplication
    public static class TestApplication {

        @Getter
        @Component("profileTok")
        public static class ProfileProperties {

            @Value("${profile.default}")
            private String defaultFile;

            @Value("${profile.production}")
            private String productionFile;

            @Value("${profile.test}")
            private String testFile;

        }
    }
}
