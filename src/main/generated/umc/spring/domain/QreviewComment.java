package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QreviewComment is a Querydsl query type for reviewComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QreviewComment extends EntityPathBase<reviewComment> {

    private static final long serialVersionUID = 1034396379L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QreviewComment reviewComment = new QreviewComment("reviewComment");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final Qreview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QreviewComment(String variable) {
        this(reviewComment.class, forVariable(variable), INITS);
    }

    public QreviewComment(Path<? extends reviewComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QreviewComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QreviewComment(PathMetadata metadata, PathInits inits) {
        this(reviewComment.class, metadata, inits);
    }

    public QreviewComment(Class<? extends reviewComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new Qreview(forProperty("review"), inits.get("review")) : null;
    }

}

