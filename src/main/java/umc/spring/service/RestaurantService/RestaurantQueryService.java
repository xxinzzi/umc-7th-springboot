package umc.spring.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findRestaurant(Long id);
    List<Restaurant> findRestaurantsByNameAndRating(String name, Float rating);
}