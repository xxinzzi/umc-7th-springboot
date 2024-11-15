package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qterm is a Querydsl query type for term
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qterm extends EntityPathBase<term> {

    private static final long serialVersionUID = -1347134728L;

    public static final Qterm term = new Qterm("term");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath optional = createBoolean("optional");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.userAgree, umc.spring.domain.mapping.QuserAgree> userAgreeList = this.<umc.spring.domain.mapping.userAgree, umc.spring.domain.mapping.QuserAgree>createList("userAgreeList", umc.spring.domain.mapping.userAgree.class, umc.spring.domain.mapping.QuserAgree.class, PathInits.DIRECT2);

    public Qterm(String variable) {
        super(term.class, forVariable(variable));
    }

    public Qterm(Path<? extends term> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qterm(PathMetadata metadata) {
        super(term.class, metadata);
    }

}

