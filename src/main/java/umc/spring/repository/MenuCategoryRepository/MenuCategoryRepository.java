package umc.spring.repository.MenuCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.MenuCategory;

import java.util.Optional;
@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
