package hasanalmunawarDev.SpringBasic.aLatihan.config;

import hasanalmunawarDev.SpringBasic.aLatihan.repo.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentConfig {

    @Bean
    public StudentRepo ItStudent(){
        log.info("create IT Student");
        return new StudentRepo();
    }

    @Bean
    public StudentRepo BisStudent(){
        log.info("create bussines Student");
        return new StudentRepo();
    }

    @Bean
    public StudentRepo AgriStudent(){
        log.info("create agri Student");
        return new StudentRepo();
    }
}
