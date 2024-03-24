package hasanalmunawarDev.SpringBasic.service;

import hasanalmunawarDev.SpringBasic.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy
//@Scope("prototype") bisa menggunakan atribut pada bean juga
@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    @Autowired // MENANDAI JIKA ADA DUA CONSTRACTOR, SEPERTI PRIMARY
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductService(ProductRepository productRepository,String name) {
        this.productRepository = productRepository;
    }

}

