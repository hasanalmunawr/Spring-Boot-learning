package hasanalmunawarDev.SpringBasic.aLatihan.servi;

import hasanalmunawarDev.SpringBasic.aLatihan.entity.Collage;
import hasanalmunawarDev.SpringBasic.aLatihan.repo.StudentRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
public class StudentServiImpl {

    private Collage collage;

    @Autowired
    @Qualifier("ItStudent")
   public StudentRepo ItStudent;

    @Autowired
    @Qualifier("BisStudent")
   public StudentRepo BisStudent;

    @Autowired
    @Qualifier("AgriStudent")
   public StudentRepo AgriStudent;



}
