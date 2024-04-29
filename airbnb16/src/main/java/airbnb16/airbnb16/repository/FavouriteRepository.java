package airbnb16.airbnb16.repository;

import airbnb16.airbnb16.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
}