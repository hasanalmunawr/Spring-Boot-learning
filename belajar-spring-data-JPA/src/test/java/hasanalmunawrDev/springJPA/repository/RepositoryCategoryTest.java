package hasanalmunawrDev.springJPA.repository;

import hasanalmunawrDev.springJPA.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RepositoryCategoryTest {

    @Autowired
    private CategoryRepository repositoryCategory;

    @Test
    void add() {
        Category category = new Category();
        category.setName("Xiaomi sgp");

        repositoryCategory.save(category);
        Assertions.assertNotNull(category.getId());
    }

    @Test
    void edit() {
        Category category = repositoryCategory.findById(1L).orElse(null);
        category.setName("Xiaomi redmi");

        repositoryCategory.save(category);
    }

    @Test
    void delete() {
        List<Category> categories = repositoryCategory.findAllByNameLike("%category%");

        repositoryCategory.deleteAll(categories);
    }

    @Test
    void findByName() {
        Category category = repositoryCategory.findFirstByNameEquals("Xiaomi redmi").orElse(null);
        Assertions.assertNotNull(category);
        Assertions.assertEquals("Xiaomi redmi", category.getName());
    }

    @Test
    void baseng() {
        List<Category> categories = repositoryCategory.findAllByNameLike("%Xiaomi%");
        Assertions.assertEquals(2, categories.size());
        Assertions.assertEquals("Xiaomi sgp", categories.get(1).getName());
    }


}