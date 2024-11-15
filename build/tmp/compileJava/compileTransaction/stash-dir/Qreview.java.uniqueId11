package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qreview is a Querydsl query type for review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qreview extends EntityPathBase<review> {

    private static final long serialVersionUID = -1868457244L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qreview review = new Qreview("review");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final Qrestaurant restaurant;

    public final ListPath<reviewComment, QreviewComment> reviewCommentList = this.<reviewComment, QreviewComment>createList("reviewCommentList", reviewComment.class, QreviewComment.class, PathInits.DIRECT2);

    public final ListPath<reviewImage, QreviewImage> reviewImageList = this.<reviewImage, QreviewImage>createList("reviewImageList", reviewImage.class, QreviewImage.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final Quser user;

    public Qreview(String variable) {
        this(review.class, forVariable(variable), INITS);
    }

    public Qreview(Path<? extends review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qreview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qreview(PathMetadata metadata, PathInits inits) {
        this(review.class, metadata, inits);
    }

    public Qreview(Class<? extends review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new Qrestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
        this.user = inits.isInitialized("user") ? new Quser(forProperty("user")) : null;
    }

}

