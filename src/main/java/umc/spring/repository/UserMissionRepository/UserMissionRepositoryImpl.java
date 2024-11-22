package umc.spring.repository.UserMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.spring.domain.QUser;
import umc.spring.domain.mapping.QUserMission;
import umc.spring.domain.mapping.UserMission;

import java.util.List;

public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom{

    private final QUserMission userMission = QUserMission.userMission;
    private final QUser user = QUser.user;

    private final JPAQueryFactory jpaQueryFactory;
    public UserMissionRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<UserMission> dynamicQueryWithBooleanBuilder(Long userId, Boolean isSuccess) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(userId != null){
            predicate.and(userMission.user.id.eq(userId));
        }
        if(isSuccess != null){
            predicate.and(userMission.isSuccess.eq(isSuccess));
        }
        return jpaQueryFactory
                .selectFrom(userMission)
                .join(userMission.user, user).fetchJoin()
                .where(predicate)
                .fetch();

    }
}
