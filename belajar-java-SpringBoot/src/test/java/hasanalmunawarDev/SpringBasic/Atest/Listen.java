package hasanalmunawarDev.SpringBasic.Atest;

import hasanalmunawarDev.SpringBasic.Listener.StudentRegisListener;
import hasanalmunawarDev.SpringBasic.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


public class Listen {

    @Configuration
    @Import(StudentRegisListener.class)
  public static class regist{

        @Bean
        public StudentService service(){
            return new StudentService();
        }
  }

  private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(regist.class);
        context.registerShutdownHook();
    }

    @Test
    void testRegis() {
        StudentService service = context.getBean(StudentService.class);
        service.register("hasan");
        service.register("udin");
    }
}
