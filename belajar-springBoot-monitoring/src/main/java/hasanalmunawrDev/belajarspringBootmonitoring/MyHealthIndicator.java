package hasanalmunawrDev.belajarspringBootmonitoring;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component // COSTUM CHECK HEALTH
public class MyHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.status(Status.UP);
        builder.withDetail("app", "OK");
        builder.withDetail("error", "NO ERROR");
    }



    public static int[] monkeyCount(final int n){
        int[] arrayNum = new int[n];
        for (int i = 0; i < n; i++) {
            arrayNum[i] = i;
        }
        return arrayNum;
    }


}
