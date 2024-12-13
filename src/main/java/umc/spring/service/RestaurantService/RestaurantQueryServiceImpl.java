package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findRestaurantsByNameAndRating(String name, Float rating) {
        return restaurantRepository.dynamicQueryWithBooleanBuilder(name, rating);
    }
}