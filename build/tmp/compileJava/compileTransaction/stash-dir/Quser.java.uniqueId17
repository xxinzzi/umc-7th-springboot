package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Quser is a Querydsl query type for user
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Quser extends EntityPathBase<user> {

    private static final long serialVersionUID = -1347091881L;

    public static final Quser user = new Quser("user");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath addressSpec = createString("addressSpec");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.gender> gender = createEnum("gender", umc.spring.domain.enums.gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final ListPath<review, Qreview> reviewList = this.<review, Qreview>createList("reviewList", review.class, Qreview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.userStatus> status = createEnum("status", umc.spring.domain.enums.userStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.userAgree, umc.spring.domain.mapping.QuserAgree> userAgreeList = this.<umc.spring.domain.mapping.userAgree, umc.spring.domain.mapping.QuserAgree>createList("userAgreeList", umc.spring.domain.mapping.userAgree.class, umc.spring.domain.mapping.QuserAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.userMission, umc.spring.domain.mapping.QuserMission> userMissionList = this.<umc.spring.domain.mapping.userMission, umc.spring.domain.mapping.QuserMission>createList("userMissionList", umc.spring.domain.mapping.userMission.class, umc.spring.domain.mapping.QuserMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.userPrefer, umc.spring.domain.mapping.QuserPrefer> userPreferList = this.<umc.spring.domain.mapping.userPrefer, umc.spring.domain.mapping.QuserPrefer>createList("userPreferList", umc.spring.domain.mapping.userPrefer.class, umc.spring.domain.mapping.QuserPrefer.class, PathInits.DIRECT2);

    public Quser(String variable) {
        super(user.class, forVariable(variable));
    }

    public Quser(Path<? extends user> path) {
        super(path.getType(), path.getMetadata());
    }

    public Quser(PathMetadata metadata) {
        super(user.class, metadata);
    }

}

