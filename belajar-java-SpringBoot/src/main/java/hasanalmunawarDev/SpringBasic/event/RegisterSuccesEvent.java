package hasanalmunawarDev.SpringBasic.event;

import hasanalmunawarDev.SpringBasic.aLatihan.entity.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Getter
public class RegisterSuccesEvent extends ApplicationEvent {

    private Student student;
    public RegisterSuccesEvent(Student  student) {
        super(student);
        this.student = student;
    }
}
