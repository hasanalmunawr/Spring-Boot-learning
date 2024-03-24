package hasanalmunawrDev.springJPA.repository;

import hasanalmunawrDev.springJPA.entity.Category;
import hasanalmunawrDev.springJPA.entity.Product;
import hasanalmunawrDev.springJPA.model.ProductPrice;
import hasanalmunawrDev.springJPA.model.SimpleProduct;
import jakarta.persistence.Lob;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
@NamedQueries({
        @NamedQuery(name = "product.searchProductByName",
        query = "SELECT p FROM Product p WHERE p.name = name")
})
public interface ProductRepository extends JpaRepository<Product, Long>,
                                            JpaSpecificationExecutor<Product> {

    @Modifying
    @Query("delete from Product p where p.name = :name")
    int deleteProductUsingName(@Param("name") String name);


//    @Modifying
//    @Query("update Product p set p.price = 0 where p.id = :id")
//    int updateProductPriceToZero(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Product p set p.price = 0 where p.id = :id")
    int updateProductPriceToZero(@Param("id") Long id);

    List<Product> findByCategory_Name(String name);

    List<Product> findByCategory_Name(String name, Sort sort);
    Page<Product> findByCategory_Name(String name, Pageable pageable);


    Long countByCategory_Name(String name);

    boolean existsByName(String name);

    @Transactional
    Integer deleteByName(String name);

    Page<Product> searchProductByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select p from Product p where p.name like :name or p.category.name like :name",
            countQuery = "select count(p) from Product p where p.name like :name or p.category.name like :name")
    Page<Product> searchProduct(@Param("name") String name, Pageable pageable);


    Stream<Product> streamAllByCategory(Category category);

    Slice<Product> findAllByCategory(Category category, Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findFirstById(Long id);

    List<SimpleProduct> findAllByNameLike(String name);

    List<ProductPrice> findAllPriceByNameLike(String name);

    /*Prefix : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */


}
