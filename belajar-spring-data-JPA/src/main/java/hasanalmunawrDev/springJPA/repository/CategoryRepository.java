package hasanalmunawrDev.springJPA.repository;

import hasanalmunawrDev.springJPA.entity.Category;
import hasanalmunawrDev.springJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findFirstByNameEquals(String name);

    List<Category> findAllByNameLike(String Name);

}
