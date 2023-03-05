package coen241.calendarApp.controller;

import coen241.calendarApp.model.User;
import coen241.calendarApp.service.EventService;
import coen241.calendarApp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public List<Event> getAllEvents() {return eventService.getAllEvent();}

    @GetMapping("/{id}")
    public Event get(@PathVariable Long id) {
        Event event = eventService.getEvent(id);
        if (event == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return event;
    }
    @GetMapping("/location/{location}")
    public List<Event> getByLocation(@PathVariable String location) {
        List<Event> events = eventService.getEventsByLocation(location);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/publisher/{publisher}")
    public List<Event> getByPublisher(@PathVariable String publisher) {
        List<Event> events = eventService.getEventsByPublisher(publisher);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/eventDate/{eventDate}")
    public List<Event> getByEventDate(@PathVariable Date eventDate) {
        List<Event> events = eventService.getEventsByEventDate(eventDate);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/eventDate/{eventDate}/location/{location}")
    public List<Event> getByDateAndLocation(@PathVariable Date eventDate, @PathVariable String location) {
        List<Event> events = eventService.getEventsByDateAndLocation(eventDate, location);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/valid/{valid}")
    public List<Event> getByValid(@PathVariable Integer valid) {
        List<Event> events = eventService.getEventsByValid(valid);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }



    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
        return "Event Added Successfully.";
    }
}