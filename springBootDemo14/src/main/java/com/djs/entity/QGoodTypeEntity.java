package com.djs.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodTypeEntity is a Querydsl query type for GoodTypeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodTypeEntity extends EntityPathBase<GoodTypeEntity> {

    private static final long serialVersionUID = -693338825L;

    public static final QGoodTypeEntity goodTypeEntity = new QGoodTypeEntity("goodTypeEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isShow = createString("isShow");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> order = createNumber("order", Integer.class);

    public QGoodTypeEntity(String variable) {
        super(GoodTypeEntity.class, forVariable(variable));
    }

    public QGoodTypeEntity(Path<? extends GoodTypeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodTypeEntity(PathMetadata metadata) {
        super(GoodTypeEntity.class, metadata);
    }

}

