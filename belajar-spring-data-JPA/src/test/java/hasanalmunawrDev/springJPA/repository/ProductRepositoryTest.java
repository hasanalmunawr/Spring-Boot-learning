package hasanalmunawrDev.springJPA.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hasanalmunawrDev.springJPA.entity.Category;
import hasanalmunawrDev.springJPA.entity.Product;
import hasanalmunawrDev.springJPA.model.ProductPrice;
import hasanalmunawrDev.springJPA.model.SimpleProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.support.TransactionOperations;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void create() {
        Category redmi = categoryRepository.findFirstByNameEquals("Xiaomi redmi").orElse(null);
        Assertions.assertNotNull(redmi);
        {
            Product product = new Product();
            product.setName("Redmi note 13");
            product.setPrice(2_800_000L);
            product.setCategory(redmi);
            productRepository.save(product);
        }
        {
            Product product = new Product();
            product.setName("Redmi note 13 Pro");
            product.setPrice(3_800_000L);
            product.setCategory(redmi);
            productRepository.save(product);
        }
    }

    @Test
    void findProducts() {
        List<Product> xiaomiRedmi = productRepository.findByCategory_Name("Xiaomi redmi");
        Assertions.assertEquals(2, xiaomiRedmi.size());
        Assertions.assertEquals("Redmi note 13", xiaomiRedmi.get(0).getName());
        Assertions.assertEquals("Redmi note 13 Pro", xiaomiRedmi.get(1).getName());
    }

    @Test
    void sort() {
        Sort sort = Sort.by(Sort.Order.asc("id"));
        List<Product> xiaomiRedmi = productRepository.findByCategory_Name("Xiaomi redmi");
        Assertions.assertEquals("Redmi note 13 Pro", xiaomiRedmi.get(1).getName());
        Assertions.assertEquals("Redmi note 13", xiaomiRedmi.get(0).getName());
    }

//    @Test
//    void pagable() {
//        // PAGE 01
//        Pageable pageable = PageRequest.of(0,1, Sort.by(Sort.Order.desc("id")));
//        List<Product> xiaomiRedmi = productRepository.findByCategory_Name("Xiaomi redmi", pageable);
//
//        Assertions.assertEquals(1,xiaomiRedmi.size());
//        Assertions.assertEquals("Redmi note 13 Pro", xiaomiRedmi.get(0).getName());
//
//        // PAGE 02
//        Pageable pageable1 = PageRequest.of(1,1, Sort.by(Sort.Order.desc("id")));
//        List<Product> xiaomiRedmi1 = productRepository.findByCategory_Name("Xiaomi redmi", pageable1);
//
//        Assertions.assertEquals(1,xiaomiRedmi1.size());
//        Assertions.assertEquals("Redmi note 13", xiaomiRedmi1.get(0).getName());
//
//
//    }


    @Test
    void pageResult() {
        // PAGE 01
        Pageable pageable = PageRequest.of(0,1, Sort.by(Sort.Order.desc("id")));
        Page<Product> xiaomiRedmi = productRepository.findByCategory_Name("xiaomi redmi", pageable);

        Assertions.assertEquals(1, xiaomiRedmi.getContent().size());
        Assertions.assertEquals(0, xiaomiRedmi.getNumber());
        Assertions.assertEquals(2, xiaomiRedmi.getTotalElements());
        Assertions.assertEquals(2, xiaomiRedmi.getTotalPages());

        Pageable pageable2 = PageRequest.of(1,1, Sort.by(Sort.Order.desc("id")));
        Page<Product> xiaomiRedmi2 = productRepository.findByCategory_Name("xiaomi redmi", pageable2);

        Assertions.assertEquals(1, xiaomiRedmi2.getContent().size());
        Assertions.assertEquals(1, xiaomiRedmi2.getNumber());
        Assertions.assertEquals(2, xiaomiRedmi2.getTotalElements());
        Assertions.assertEquals(2, xiaomiRedmi2.getTotalPages());

    }

    @Test
    void count() {
        long count = productRepository.count();
        Assertions.assertEquals(2L, count);

        Long xiaomiRedmi = productRepository.countByCategory_Name("Xiaomi redmi");
        Assertions.assertEquals(2L, xiaomiRedmi);
    }

    @Test
    void exists() {
        boolean exist = productRepository.existsByName("Redmi note 13");
        Assertions.assertTrue(exist);

        boolean pocoX6 = productRepository.existsByName("Poco x6");
        Assertions.assertFalse(pocoX6);

    }

    @Test
    void deleteOld() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            Category category = categoryRepository.findFirstByNameEquals("Xiaomi redmi").orElse(null);
            Product product = new Product();
            product.setName("Poco M6 Pro");
            product.setPrice(2_900_000L);
            product.setCategory(category);
            productRepository.save(product);

            Integer pocoM6Pro = productRepository.deleteByName("Poco M6 Pro");
            Assertions.assertEquals(1, pocoM6Pro);

            pocoM6Pro = productRepository.deleteByName("Poco M6 Pro");
            Assertions.assertEquals(0,pocoM6Pro);
        });
    }

    @Test
    void deleteNew() {
//        Category category = categoryRepository.findFirstByNameEquals("Xiaomi redmi").orElse(null);
//        Product product = new Product();
//        product.setName("Poco M6 Pro");
//        product.setPrice(2_900_000L);
//        product.setCategory(category);
//        productRepository.save(product);

        Integer pocoM6Pro = productRepository.deleteByName("Poco M6 Pro");
        Assertions.assertEquals(1, pocoM6Pro);

        pocoM6Pro = productRepository.deleteByName("Poco M6 Pro");
        Assertions.assertEquals(0,pocoM6Pro);
    }

    @Test
    void searchByNamedQuery() {
        Pageable pageable = PageRequest.of(0,1);
        Page<Product> products = productRepository.searchProductByName("Redmi note 13", pageable);
//        Assertions.assertEquals(1, products.getTotalPages());
//        Assertions.assertEquals(1, products.getTotalElements());
//        Assertions.assertEquals("Redmi note 13", products.get(0).getName());

        Assertions.assertEquals(1, products.getContent().size());
        Assertions.assertEquals(0, products.getNumber());
        Assertions.assertEquals(1, products.getTotalElements());
        Assertions.assertEquals(1, products.getTotalPages());
    }

    @Test
    void queryNative() {
        Pageable pageable = PageRequest.of(0,1, Sort.by(Sort.Order.desc("id")));
        Page<Product> products = productRepository.searchProduct("%Redmi%", pageable);
        assertEquals(1, products.getContent().size());

        products = productRepository.searchProduct("%note%", pageable);
        assertEquals(1, products.getContent().size());

    }

    @Test
    void serachProducts() {
        Pageable pageable = PageRequest.of(0,1, Sort.by(Sort.Order.desc("id")));
        Page<Product> products = productRepository.searchProduct("%Redmi%", pageable);
        assertEquals(1, products.getContent().size());
    }

    @Test
    void modifyByDelete() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);
        Product product = new Product();
        product.setName("Poco x6 Pro");
        product.setPrice(4_000_000L);
        product.setCategory(category);
        productRepository.save(product);

        Integer pocoX6Pro = productRepository.deleteByName("Poco x6 Pro");
        assertEquals(1, pocoX6Pro);
    }

    @Test
    void modifyByUpdate() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            int updated = productRepository.updateProductPriceToZero(1L);
            assertEquals(1, updated);

            Product product = productRepository.findById(1L).orElse(null);
            assertEquals(0L, product.getPrice());
        });
    }

    @Test
    void modifyByUpdateNotTransactional() {
            int updated = productRepository.updateProductPriceToZero(1L);
            assertEquals(1, updated);

            Product product = productRepository.findById(1L).orElse(null);
            assertEquals(0L, product.getPrice());
    }

    @Test
    void stream() {
        transactionOperations.executeWithoutResult(transactionStatus -> {

            Category category = categoryRepository.findById(1L).orElse(null); // transactional 01
            Stream<Product> productStream = productRepository.streamAllByCategory(category); // transactional 02
            productStream.forEach(product -> {
                System.out.println(product.getId() + " : " + product.getName() + " : " + product.getPrice());
            });

        });
    }

    @Test
    void slice() {
        Pageable firstPage = PageRequest.of(0, 1);

        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        Slice<Product> slice = productRepository.findAllByCategory(category, firstPage);
        // tampilkan konten product
        while (slice.hasNext()) {
            slice = productRepository.findAllByCategory(category, slice.nextPageable());
            // tampilkan konten product
        }
    }

    @Test
    void lock() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            try {
                Product firstById = productRepository.findFirstById(1L).orElse(null);
                firstById.setPrice(16_000_000L);
                 Thread.sleep(20_000L);

                 productRepository.save(firstById);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void lock2() {
        transactionOperations.executeWithoutResult(transactionStatus -> {
            Product firstById = productRepository.findFirstById(1L).orElse(null);
            firstById.setPrice(12_000L);
            productRepository.save(firstById);
        });
    }

    @Test
    void auditingListener() {
        Category category = categoryRepository.findById(1L).orElse(null);
        Product product = new Product();
        product.setName("Poco M6 Pro");
        product.setPrice(2_900_000L);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Test
    void example() {
        Category category = new Category();
        category.setName("Xiaomi redmi");

        Example<Category> categoryExample = Example.of(category);

        List<Category> all = categoryRepository.findAll(categoryExample);
        Assertions.assertEquals(1, all.size());
    }

    @Test
    void exampleMatcher() {
        Category category = new Category();
        category.setName("xiaomi REDMI");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withIgnoreCase();

        Example<Category> example = Example.of(category, matcher);

        List<Category> categories = categoryRepository.findAll(example);
        assertEquals(1, categories.size());
    }

    @Test
    void specification() {
        Specification<Product> specification = (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaQuery.where(
                    criteriaBuilder.or(
                            criteriaBuilder.equal(root.get("name"), "Redmi note 13"),
                            criteriaBuilder.equal(root.get("name"), "Redmi note 13 Pro"),
                            criteriaBuilder.equal(root.get("name"), "Poco M6 Pro")
                    )
            ).getRestriction();
        };

        List<Product> products = productRepository.findAll(specification);
        products.forEach(product -> {
            System.out.println(product.getId()+":"+product.getName());
        });
        Assertions.assertEquals(3, products.size());
    }

    @Test
    void projectionByInterface() { //using for query more specific adn dinamis
        List<SimpleProduct> allByNameLike = productRepository.findAllByNameLike("%Redmi%");
        assertEquals(2, allByNameLike.size());
        allByNameLike.forEach(product -> {
            System.out.println(product.getId()+":"+product.getName());
        });
    }

    @Test
    void projectionByRecord() { // Just avaible on java 17++
        List<ProductPrice> pro = productRepository.findAllPriceByNameLike("%Pro%");
        assertEquals(2, pro.size());
    }
}