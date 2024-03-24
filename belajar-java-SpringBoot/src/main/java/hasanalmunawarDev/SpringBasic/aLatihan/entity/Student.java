package hasanalmunawarDev.SpringBasic.aLatihan.entity;

import hasanalmunawarDev.SpringBasic.aware.NimAware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class Student implements NimAware {

    private String nim ;

    private String name;
    @Override
    public void setNim(String id) {
        this.nim = id;
    }

    public Student(String name) {
        this.name = name;
    }
}
