package com.calendar.calendar.repository;

import com.calendar.calendar.exceptions.DaoException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public class Repository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public T findById(Class<T> t,long id) throws Exception{
        try {
            return entityManager.find(t,id);
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }

    }

    public T save(T entity)throws Exception{
        try {
            entityManager.persist(entity);
            return entity;
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }

    public void delete(T entity)throws Exception{
        try {
            entityManager.remove(entity);
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }

    public T update(T entity)throws Exception{
        try {
            entityManager.merge(entity);
            return entity;
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }


}
