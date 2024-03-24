package hasanalmunawarDev.SpringBasic.factory;

import hasanalmunawarDev.SpringBasic.client.PaymentGateway;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("paymentGateway")
public class PaymentGatewayFactoryBean implements FactoryBean<PaymentGateway> {
    @Override
    public PaymentGateway getObject() throws Exception {
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setEndPoint("https://payment/");
        paymentGateway.setPublicKey("public");
        paymentGateway.setPrivateKey("private");

        return paymentGateway;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGateway.class;
    }
}
