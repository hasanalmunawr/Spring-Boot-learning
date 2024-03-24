package hasanalmunawrDev.springJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityManagerFactoryTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void test() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Assertions.assertNotNull(entityManagerFactory);
        Assertions.assertNotNull(entityManager);

        entityManager.close();

    }
}
