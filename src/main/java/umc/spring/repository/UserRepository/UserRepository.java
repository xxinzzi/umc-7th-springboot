package umc.spring.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.spring.domain.User;
import umc.spring.domain.enums.UserStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.status = :status")
    List<User> findByNameAndStatus(@Param("name") String name, @Param("status") UserStatus status);
    Optional<User> findByEmail(String email);
}
