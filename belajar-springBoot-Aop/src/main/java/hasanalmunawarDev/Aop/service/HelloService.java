package hasanalmunawarDev.Aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloService {

    public String hello(String name) {
        log.info("call hello from hello()");
        return "Hello " + name;
    }
    public String bye(String name) {
        log.info("call bye from bye()");
        return "Bye " + name;
    }

    public String introduction(String firstName, String lastName) {
        return "Hello my name is "+firstName+" "+lastName;
    }

    public void test(){
        log.info("invoke test()");
    }


}
