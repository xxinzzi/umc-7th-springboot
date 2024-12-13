package umc.spring.repository.MenuCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MenuCategory;

import java.util.Optional;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
