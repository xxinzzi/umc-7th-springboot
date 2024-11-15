package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QuserAgree is a Querydsl query type for userAgree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QuserAgree extends EntityPathBase<userAgree> {

    private static final long serialVersionUID = 1968729461L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QuserAgree userAgree = new QuserAgree("userAgree");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.Qterm term;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.Quser user;

    public QuserAgree(String variable) {
        this(userAgree.class, forVariable(variable), INITS);
    }

    public QuserAgree(Path<? extends userAgree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QuserAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QuserAgree(PathMetadata metadata, PathInits inits) {
        this(userAgree.class, metadata, inits);
    }

    public QuserAgree(Class<? extends userAgree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.term = inits.isInitialized("term") ? new umc.spring.domain.Qterm(forProperty("term")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.Quser(forProperty("user")) : null;
    }

}

