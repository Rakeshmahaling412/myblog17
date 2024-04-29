package airbnb16.airbnb16.repository;

import airbnb16.airbnb16.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLocationName(String locationName);
}