package com.calendar.calendar.service;

import com.calendar.calendar.models.Event;
import com.calendar.calendar.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepo repository;

    public Event save(Event event) throws Exception {
        return repository.save(event);
    }

    public void deleteById (long id) throws Exception {
        repository.deleteById(id);
    }

    public Event update(Event event) throws Exception {
        return repository.update(event);
    }

    public List<Event> getAll() throws Exception{
        return repository.getAll();
    }

    public List<Event> findByText(String text) throws Exception{
        return repository.findByText(text);
    }

    public List<Event> getAll(Date dateFrom, Date dateTo) throws Exception{
        return repository.getAll( dateFrom,dateTo);
    }
}
