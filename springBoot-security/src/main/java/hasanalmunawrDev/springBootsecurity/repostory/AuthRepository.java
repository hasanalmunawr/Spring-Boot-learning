package hasanalmunawrDev.springBootsecurity.repostory;

import hasanalmunawrDev.springBootsecurity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, String> {
    boolean existsByUsername(String username);

    Optional<Auth> findByUsername(String username);
}
