package hasanalmunawarDev.SpringBasic.service;

import hasanalmunawarDev.SpringBasic.aLatihan.entity.Student;
import hasanalmunawarDev.SpringBasic.client.PaymentGateway;
import hasanalmunawarDev.SpringBasic.event.RegisterSuccesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class StudentService implements ApplicationEventPublisherAware  {

    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean register(String name) {
        if(isRegis(name)){
            applicationEventPublisher.publishEvent(new RegisterSuccesEvent(new Student(name)));
            return true;
        } else {
            return false;
        }
    }

    private boolean isRegis(String name) {
        return !name.isBlank();
    }
}
