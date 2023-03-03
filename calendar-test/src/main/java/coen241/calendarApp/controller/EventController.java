package coen241.calendarApp.controller;

import coen241.calendarApp.service.EventService;
import coen241.calendarApp.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {return eventService.getAllEvent();}

    @GetMapping("/events/{id}")
    public Event get(@PathVariable Long id) {
        Event event = eventService.getEvent(id);
        if (event == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return event;
    }
    @GetMapping("/events/location/{location}")
    public List<Event> getByLocation(@PathVariable String location) {
        List<Event> events = eventService.getEventsByLocation(location);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/events/publisher/{publisherId}")
    public List<Event> getByPublisher(@PathVariable Long publisherId) {
        List<Event> events = eventService.getEventsByPublisherId(publisherId);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/events/eventDate/{eventDate}")
    public List<Event> getByEventDate(@PathVariable Date eventDate) {
        List<Event> events = eventService.getEventsByEventDate(eventDate);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }
    @GetMapping("/events/valid/{valid}")
    public List<Event> getByValid(@PathVariable Integer valid) {
        List<Event> events = eventService.getEventsByValid(valid);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }


//    @RequestMapping(value="/add-event", method= RequestMethod.POST)
//    public void addEvent(@RequestBody Event event)
//    {
//        eventService.addEvent(event);
//    }
}
