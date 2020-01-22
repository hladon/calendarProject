package com.calendar.calendar.repository;

import com.calendar.calendar.exceptions.DaoException;
import com.calendar.calendar.models.Event;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public class EventRepo extends Repository<Event> {

    public Event findById(long id) throws Exception {
        return findById(Event.class, id);
    }

    public void deleteById(long id) throws Exception {
        try {
            entityManager.createQuery("DELETE FROM Event e WHERE e.id=?1")
                    .setParameter(1, id).executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    public List<Event> getAll() throws Exception {
        try {
            return entityManager.createQuery("SELECT e FROM Event e", Event.class)
                    .getResultList();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }

    }

    public List<Event> findByText(String text) throws Exception {
        try {
            String searchText = "%" + text.toUpperCase() + "%";
            return entityManager.createNativeQuery("SELECT * FROM EVENT WHERE UPPER(NAME) LIKE ?1 " +
                    "OR UPPER(DESCRIPTION) LIKE ?1", Event.class)
                    .setParameter(1, searchText)
                    .getResultList();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }

    }

    public List<Event> getAll(Date dateFrom, Date dateTo) throws Exception {
        try {
            return entityManager.createNativeQuery("SELECT * FROM EVENT WHERE START_DATE BETWEEN ?1 AND ?2 ", Event.class)
                    .setParameter(1, dateFrom, TemporalType.TIMESTAMP)
                    .setParameter(2, dateTo, TemporalType.TIMESTAMP)
                    .getResultList();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }

    }
}
