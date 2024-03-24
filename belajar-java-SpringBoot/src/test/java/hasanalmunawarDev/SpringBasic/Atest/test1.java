package hasanalmunawarDev.SpringBasic.Atest;

import hasanalmunawarDev.SpringBasic.aLatihan.FactoConfig;
import hasanalmunawarDev.SpringBasic.aLatihan.MainConfig;
import hasanalmunawarDev.SpringBasic.aLatihan.entity.Collage;
import hasanalmunawarDev.SpringBasic.aLatihan.entity.Major;
import hasanalmunawarDev.SpringBasic.aLatihan.entity.Student;
import hasanalmunawarDev.SpringBasic.aLatihan.servi.StudentServiImpl;
import hasanalmunawarDev.SpringBasic.aware.NimAware;
import hasanalmunawarDev.SpringBasic.processor.NimGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


public class test1 {

    private ConfigurableApplicationContext context;
    private ConfigurableApplicationContext context1;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(MainConfig.class);
        context1 = new AnnotationConfigReactiveWebApplicationContext(FactoConfig.class);
        context.registerShutdownHook();
        context1.registerShutdownHook();
    }

    @Test
    void test() {
        Student student = context.getBean(Student.class);
        Major bean = context.getBean(Major.class);

        Assertions.assertNotNull(student);
        Assertions.assertNotNull(bean);
    }

    @Test
    void test2() {
        Collage collage = context.getBean(Collage.class);
        Student student = context.getBean(Student.class);
        Major major = context.getBean(Major.class);

        Assertions.assertNotSame(major,collage.getMajor());
        Assertions.assertSame(student, collage.getStudent());
    }

    @Test
    void test3() {
        StudentServiImpl servi = context.getBean(StudentServiImpl.class);

        Assertions.assertNotNull(servi.getItStudent());
        Assertions.assertNotNull(servi.getAgriStudent());
        Assertions.assertNotNull(servi.getBisStudent());
    }

    @Test
    void factoryBean() {
        Major major = context1.getBean(Major.class);

        Assertions.assertSame("9913", major.getId());
        Assertions.assertSame("Informatic engginering", major.getName());
        Assertions.assertSame("Singkut", major.getAddres());
    }


    @Configuration
    @Import({
            Student.class,
            NimGeneratorBeanPostProcessor.class
    })
    public static class testNimConfiguration{

    }

    private ConfigurableApplicationContext context2;

    @Test
    void testCreateNim() {
        context2 = new AnnotationConfigReactiveWebApplicationContext(testNimConfiguration.class);

        Student student = context2.getBean(Student.class);
        Assertions.assertNotNull(student.getNim());
        System.out.println(student.getNim());
    }
}
