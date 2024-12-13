package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;
import com.querydsl.core.BooleanBuilder;

import java.util.List;

public class MissionRepositoryImpl implements MissionRepositoryCustom{
    private final QMission mission = QMission.mission;
    private final JPAQueryFactory jpaQueryFactory;

    // 생성자를 통해 JPAQueryFactory 주입
    public MissionRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }
    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(Long regionId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(regionId != null){
            predicate.and(mission.restaurant.region.id.eq(regionId));
        }
        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }
}
