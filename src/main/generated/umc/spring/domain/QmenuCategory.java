package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QmenuCategory is a Querydsl query type for menuCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QmenuCategory extends EntityPathBase<menuCategory> {

    private static final long serialVersionUID = 251998729L;

    public static final QmenuCategory menuCategory = new QmenuCategory("menuCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QmenuCategory(String variable) {
        super(menuCategory.class, forVariable(variable));
    }

    public QmenuCategory(Path<? extends menuCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QmenuCategory(PathMetadata metadata) {
        super(menuCategory.class, metadata);
    }

}

