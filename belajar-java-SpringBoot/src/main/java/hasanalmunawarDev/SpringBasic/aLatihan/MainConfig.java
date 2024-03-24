package hasanalmunawarDev.SpringBasic.aLatihan;

import hasanalmunawarDev.SpringBasic.aLatihan.config.StudentConfig;
import hasanalmunawarDev.SpringBasic.aLatihan.entity.Collage;
import hasanalmunawarDev.SpringBasic.aLatihan.entity.Major;
import hasanalmunawarDev.SpringBasic.aLatihan.entity.Student;
import hasanalmunawarDev.SpringBasic.aLatihan.servi.StudentServiImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@Import({
        Major.class,
        Student.class,
        StudentConfig.class,
        StudentServiImpl.class
})
//@ComponentScan({
//        "hasanalmunawarDev.SpringBasic.aLatihan.entity",
//        "hasanalmunawarDev.SpringBasic.aLatihan.config",
//
//})
public class MainConfig {

}
