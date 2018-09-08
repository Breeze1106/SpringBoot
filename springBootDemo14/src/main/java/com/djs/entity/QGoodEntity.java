package com.djs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodEntity is a Querydsl query type for GoodEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodEntity extends EntityPathBase<GoodEntity> {

    private static final long serialVersionUID = 2116461149L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodEntity goodEntity = new QGoodEntity("goodEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> order = createNumber("order", Integer.class);

    public final StringPath price = createString("price");

    public final StringPath title = createString("title");

    public final QGoodTypeEntity type;

    public final StringPath unit = createString("unit");

    public QGoodEntity(String variable) {
        this(GoodEntity.class, forVariable(variable), INITS);
    }

    public QGoodEntity(Path<? extends GoodEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodEntity(PathMetadata metadata, PathInits inits) {
        this(GoodEntity.class, metadata, inits);
    }

    public QGoodEntity(Class<? extends GoodEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.type = inits.isInitialized("type") ? new QGoodTypeEntity(forProperty("type")) : null;
    }

}

