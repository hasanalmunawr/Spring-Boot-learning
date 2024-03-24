package hasanalmunawarDev.SpringBasic.application;

import hasanalmunawarDev.SpringBasic.aLatihan.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StudentApplication.class, args);
        Student student = context.getBean(Student.class);
    }

    @Bean
    public Student student(){
        return new Student();
    }
}
