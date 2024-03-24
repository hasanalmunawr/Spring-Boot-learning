package hasanalmunawrDev.webMvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String call(String name) {
        if(name.isBlank()) {
            return "hello guest";
        }
        return "hello " + name;
    }
}
