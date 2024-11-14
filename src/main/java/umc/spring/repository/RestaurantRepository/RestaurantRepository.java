package umc.spring.repository.RestaurantRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.restaurant;

public interface RestaurantRepository extends JpaRepository<restaurant, Long>, RestaurantRepositoryCustom {
}