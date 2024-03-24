package hasanalmunawarDev.SpringBasic.client;

import lombok.Data;

@Data
public class PaymentGateway {

    private String endPoint;

    private String publicKey;

    private String privateKey;
}
