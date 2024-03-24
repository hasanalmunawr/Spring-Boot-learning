package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.repository.CategoryRepository;
import hasanalmunawarDev.SpringBasic.repository.CustomerRepository;
import hasanalmunawarDev.SpringBasic.repository.ProductRepository;
import hasanalmunawarDev.SpringBasic.service.CategoryService;
import hasanalmunawarDev.SpringBasic.service.CustomerService;
import hasanalmunawarDev.SpringBasic.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class ConstractorBasedTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(ComponentConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testConstractor() {
        ProductRepository repository = context.getBean(ProductRepository.class);
        Assertions.assertNotNull(repository);

        ProductService service = context.getBean(ProductService.class);
        Assertions.assertSame(repository, service.getProductRepository());
    }

    @Test
    void setterBassed() {
        CategoryRepository repository = context.getBean(CategoryRepository.class);
        Assertions.assertNotNull(repository);

        CategoryService service = context.getBean(CategoryService.class);
        Assertions.assertSame(repository, service.getCategoryRepository());
    }

    @Test
    void fieldBassed() {
        CustomerRepository repository = context.getBean(CustomerRepository.class);
         CustomerService service = context.getBean(CustomerService.class);
        Assertions.assertSame(repository, service.getNormalCustomerRepository());
    }

    @Test
    void qualifier() {
        CustomerService bean = context.getBean(CustomerService.class);
    }

@Test
    void fieldDepedencyInjection() {
        CustomerService service = context.getBean(CustomerService.class);

        Assertions.assertNotNull(service.getPremiumCustomerRepository());
        Assertions.assertNotNull(service.getNormalCustomerRepository());

        Assertions.assertNotSame(service.getNormalCustomerRepository(),
                service.getPremiumCustomerRepository());

    }


}
