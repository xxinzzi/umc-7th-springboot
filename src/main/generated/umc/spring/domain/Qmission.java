package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qmission is a Querydsl query type for mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qmission extends EntityPathBase<mission> {

    private static final long serialVersionUID = -2118103168L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qmission mission = new Qmission("mission");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> deadline = createDate("deadline", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath missionSpec = createString("missionSpec");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final Qrestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.userMission, umc.spring.domain.mapping.QuserMission> userMissionList = this.<umc.spring.domain.mapping.userMission, umc.spring.domain.mapping.QuserMission>createList("userMissionList", umc.spring.domain.mapping.userMission.class, umc.spring.domain.mapping.QuserMission.class, PathInits.DIRECT2);

    public Qmission(String variable) {
        this(mission.class, forVariable(variable), INITS);
    }

    public Qmission(Path<? extends mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qmission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qmission(PathMetadata metadata, PathInits inits) {
        this(mission.class, metadata, inits);
    }

    public Qmission(Class<? extends mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new Qrestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

