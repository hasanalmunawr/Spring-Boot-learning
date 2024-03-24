package hasanalmunawarDev.SpringBasic.service;


import hasanalmunawarDev.SpringBasic.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class CustomerService {

//    @Getter
//    @Autowired // tidak direkomendasikan lagi
//    private CustomerRepository customerRepository;

    @Getter
    @Autowired
    @Qualifier("normalCustomerRepository")
    public CustomerRepository normalCustomerRepository;

    @Getter
    @Autowired
    @Qualifier("premiumCustomerRepository")
    public CustomerRepository premiumCustomerRepository;
}
