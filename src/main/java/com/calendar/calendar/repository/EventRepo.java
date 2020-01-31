package com.calendar.calendar.repository;

import com.calendar.calendar.models.Event;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public class EventRepo extends Repository<Event> {

    String DELETE_BY_ID = "DELETE FROM Event e WHERE e.id=?1";
    String SELECT = "SELECT e FROM Event e";
    String FIND_BY_TEXT = "SELECT * FROM EVENT WHERE UPPER(NAME) LIKE ?1 OR UPPER(DESCRIPTION) LIKE ?1";
    String FIND_BY_DATE = "SELECT * FROM EVENT WHERE START_DATE BETWEEN ?1 AND ?2 ";

    public Event findById(long id) throws Exception {
        return findById(Event.class, id);
    }

    public void deleteById(long id) throws Exception {
        entityManager.createQuery(DELETE_BY_ID)
                .setParameter(1, id).executeUpdate();
    }

    public List<Event> getAll() throws Exception {
        return entityManager.createQuery(SELECT, Event.class)
                .getResultList();

    }

    public List<Event> findByText(String text) throws Exception {
        String searchText = "%" + text.toUpperCase() + "%";
        return entityManager.createNativeQuery(FIND_BY_TEXT, Event.class)
                .setParameter(1, searchText)
                .getResultList();


    }

    public List<Event> getAll(Date dateFrom, Date dateTo) throws Exception {
        return entityManager.createNativeQuery(FIND_BY_DATE, Event.class)
                .setParameter(1, dateFrom, TemporalType.TIMESTAMP)
                .setParameter(2, dateTo, TemporalType.TIMESTAMP)
                .getResultList();

    }
}
