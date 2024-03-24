package hasanalmunawrDev.springJPA.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService serviceCategory;


    @Test
    void succes() {
        assertThrows(RuntimeException.class, () -> {
            serviceCategory.create();
        });
    }
     @Test
    void failed() { // bocor
        assertThrows(RuntimeException.class, () -> {
            serviceCategory.test(); // tidak menjalankan database transactional
        });
    }

    @Test
    void prograMatic() {
        assertThrows(RuntimeException.class, () -> {
            serviceCategory.createCategories();
        });
    }
    @Test
    void manual() {
        assertThrows(RuntimeException.class, () -> {
            serviceCategory.manual();
        });
    }

}