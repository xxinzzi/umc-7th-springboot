package umc.spring.service.RestaurantService;
import umc.spring.domain.restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<restaurant> findRestaurant(Long id);
    List<restaurant> findRestaurantsByNameAndRating(String name, Float rating);
}