package hasanalmunawarDev.springConfigProperties.profileEnvironment;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileEnvironmentTest.TestApplication.class)
@ActiveProfiles({"local", "production"})
public class ProfileEnvironmentTest {

    @Autowired
    private TestApplication.SampleProfile sampleProfile;

    @Test
    void test() {
        Assertions.assertArrayEquals(new String[]{"local", "production"}, sampleProfile.getActiveProfiles());
    }

    @SpringBootApplication
    public static class TestApplication{

        @Component
        public static class SampleProfile implements EnvironmentAware{

            @Setter
            private Environment environment;

            public String[] getActiveProfiles(){
                return environment.getActiveProfiles();
            }

        }
    }
}
