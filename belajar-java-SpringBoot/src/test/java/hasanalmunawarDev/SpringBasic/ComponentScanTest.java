package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class ComponentScanTest {

    private ApplicationContext context;
    private ApplicationContext context1;

    @BeforeEach
    void setUp() {
//        context = new AnnotationConfigReactiveWebApplicationContext(ScanConfiguration.class);
        context1 = new AnnotationConfigReactiveWebApplicationContext(ComponentConfiguration.class);
    }

//    @Test
//    void testComponentScan() {
//        Foo foo = context.getBean(Foo.class);
//        Barr bean = context.getBean(Barr.class);
//    }

    @Test
    void productSrvice() {
        ProductService bean = context1.getBean(ProductService.class);
        Assertions.assertNotNull(bean);
    }
}
