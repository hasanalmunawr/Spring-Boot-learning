package hasanalmunawarDev.SpringBasic.date;

import hasanalmunawarDev.SpringBasic.aware.IdAware;
import lombok.Getter;

public class Car implements IdAware {

    @Getter
    private String id;
    @Override
    public void setId(String id) {
        this.id =  id;
    }
}
