package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QuserMission is a Querydsl query type for userMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QuserMission extends EntityPathBase<userMission> {

    private static final long serialVersionUID = -12849643L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QuserMission userMission = new QuserMission("userMission");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> identificationNumber = createNumber("identificationNumber", Integer.class);

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final umc.spring.domain.Qmission mission;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.Quser user;

    public QuserMission(String variable) {
        this(userMission.class, forVariable(variable), INITS);
    }

    public QuserMission(Path<? extends userMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QuserMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QuserMission(PathMetadata metadata, PathInits inits) {
        this(userMission.class, metadata, inits);
    }

    public QuserMission(Class<? extends userMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new umc.spring.domain.Qmission(forProperty("mission"), inits.get("mission")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.Quser(forProperty("user")) : null;
    }

}

