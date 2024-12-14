package umc.spring.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.mapping.UserMission;
@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long>, UserMissionRepositoryCustom{
    Page<UserMission> findByUserIdAndIsSuccess(Long userId, Boolean isSuccess, Pageable pageable);
}
