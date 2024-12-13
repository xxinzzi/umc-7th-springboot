package umc.spring.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    // 추가된 메서드
    Page<Review> findAllByRestaurantId(Long restaurantId, PageRequest pageRequest);
}