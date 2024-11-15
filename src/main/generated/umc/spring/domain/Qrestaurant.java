package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrestaurant is a Querydsl query type for restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qrestaurant extends EntityPathBase<restaurant> {

    private static final long serialVersionUID = -430421815L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrestaurant restaurant = new Qrestaurant("restaurant");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QmenuCategory menuCategory;

    public final ListPath<mission, Qmission> missionList = this.<mission, Qmission>createList("missionList", mission.class, Qmission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final Qregion region;

    public final ListPath<review, Qreview> reviewList = this.<review, Qreview>createList("reviewList", review.class, Qreview.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public Qrestaurant(String variable) {
        this(restaurant.class, forVariable(variable), INITS);
    }

    public Qrestaurant(Path<? extends restaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrestaurant(PathMetadata metadata, PathInits inits) {
        this(restaurant.class, metadata, inits);
    }

    public Qrestaurant(Class<? extends restaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.menuCategory = inits.isInitialized("menuCategory") ? new QmenuCategory(forProperty("menuCategory")) : null;
        this.region = inits.isInitialized("region") ? new Qregion(forProperty("region")) : null;
    }

}

