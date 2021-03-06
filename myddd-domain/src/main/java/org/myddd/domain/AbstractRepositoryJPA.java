package org.myddd.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * JAP仓储实现的抽象父类
 */
public abstract class AbstractRepositoryJPA implements AbstractRepository{

    private static EntityRepository entityRepository;

    protected static EntityRepository getEntityRepository() {
        if(Objects.isNull(entityRepository)){
            entityRepository = InstanceFactory.getInstance(EntityRepository.class);
        }
        return entityRepository;
    }

    public <T extends Entity> T save(T entity){
        return getEntityRepository().save(entity);
    }

    public <T extends Entity> T get(Class<T> clazz, Serializable id){
        return getEntityRepository().get(clazz,id);
    }

    public <T extends Entity> boolean exists(Class<T> clazz, Serializable id){
        return getEntityRepository().exists(clazz,id);
    }

}
