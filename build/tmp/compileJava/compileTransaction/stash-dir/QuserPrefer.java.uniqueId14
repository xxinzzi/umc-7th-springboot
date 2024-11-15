package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QuserPrefer is a Querydsl query type for userPrefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QuserPrefer extends EntityPathBase<userPrefer> {

    private static final long serialVersionUID = 1340280935L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QuserPrefer userPrefer = new QuserPrefer("userPrefer");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QmenuCategory menuCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.Quser user;

    public QuserPrefer(String variable) {
        this(userPrefer.class, forVariable(variable), INITS);
    }

    public QuserPrefer(Path<? extends userPrefer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QuserPrefer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QuserPrefer(PathMetadata metadata, PathInits inits) {
        this(userPrefer.class, metadata, inits);
    }

    public QuserPrefer(Class<? extends userPrefer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.menuCategory = inits.isInitialized("menuCategory") ? new umc.spring.domain.QmenuCategory(forProperty("menuCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.Quser(forProperty("user")) : null;
    }

}

