package com.calendar.calendar.controller;


import com.calendar.calendar.models.Event;
import com.calendar.calendar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    EventService service;

    @RequestMapping(path = "save",
            method = RequestMethod.POST)
    public ResponseEntity<String> saveEvent(@RequestBody Event event) throws Exception {
        service.save(event);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @RequestMapping(path = "delete",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<String> deleteEvent(@RequestParam long id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "put",
            method = RequestMethod.PUT)
    public ResponseEntity<String> updateEvent(@RequestBody Event event) throws Exception {
        service.update(event);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(
            path = "getAll",
            method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAll() throws Exception {
        return new ResponseEntity<List<Event>>(service.getAll(), HttpStatus.OK);

    }

    @RequestMapping(
            path = "findByText",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Event>> findByText(@RequestParam String text) throws Exception {
        return new ResponseEntity<List<Event>>(service.findByText(text), HttpStatus.OK);

    }

    @RequestMapping(
            value = "getAll",
            method = RequestMethod.GET,
            params = {"dateFrom", "dateTo"}
    )
    public ResponseEntity<List<Event>> getAll(@RequestParam Date dateFrom, @RequestParam Date dateTo) throws Exception {
        return new ResponseEntity<List<Event>>(service.getAll(dateFrom, dateTo), HttpStatus.OK);
    }
}
