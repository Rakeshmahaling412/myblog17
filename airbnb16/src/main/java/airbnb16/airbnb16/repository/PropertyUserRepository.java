package airbnb16.airbnb16.repository;

import airbnb16.airbnb16.entity.PropertyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyUserRepository extends JpaRepository<PropertyUser, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<PropertyUser> findByUsername(String username);
}