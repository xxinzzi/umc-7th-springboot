package umc.spring.repository.RestaurantRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Restaurant;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, RestaurantRepositoryCustom {
    Optional<Restaurant> findById(Integer restaurantId);
}