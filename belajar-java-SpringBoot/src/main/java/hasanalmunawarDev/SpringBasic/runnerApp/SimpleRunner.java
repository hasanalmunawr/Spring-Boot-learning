package hasanalmunawarDev.SpringBasic.runnerApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SimpleRunner implements RunnerApplication{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> profiles = args.getOptionValues("profiles");
        log.info("Profiles : {}", profiles);
    }
}
