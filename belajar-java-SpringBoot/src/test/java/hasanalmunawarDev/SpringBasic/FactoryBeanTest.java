package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.client.PaymentGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class FactoryBeanTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(FactoryConfiguration.class);
    }

    @Test
    void test() {
        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
        Assertions.assertEquals("https://payment/", paymentGateway.getEndPoint());
        Assertions.assertEquals("public", paymentGateway.getPublicKey());
        Assertions.assertEquals("private", paymentGateway.getPrivateKey());
    }
}
