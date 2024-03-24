package hasanalmunawarDev.SpringBasic.application;

import hasanalmunawarDev.SpringBasic.aLatihan.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = StudentApplication.class)
public class StudentApplicationTest {

    @Autowired
    Student student;

    @Test
    void testStudent() {
        Assertions.assertNotNull(student);
    }
}
