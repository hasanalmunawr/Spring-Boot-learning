package hasanalmunawarDev.SpringBasic.date;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiFoo {

    @Getter
    private List<Foo> fooList;

    public MultiFoo(ObjectProvider<Foo> foos) {
        fooList = foos.stream().collect(Collectors.toList());
    }
}
