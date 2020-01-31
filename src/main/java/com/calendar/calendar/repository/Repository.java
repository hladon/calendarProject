package com.calendar.calendar.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public class Repository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public T findById(Class<T> t, long id) throws Exception {
        return entityManager.find(t, id);

    }

    public T save(T entity) throws Exception {
        entityManager.persist(entity);
        return entity;

    }

    public void delete(T entity) throws Exception {
        entityManager.remove(entity);

    }

    public T update(T entity) throws Exception {
        entityManager.merge(entity);
        return entity;

    }


}
