package coen241.calendarApp.controller;

import coen241.calendarApp.model.RSVP;
import coen241.calendarApp.model.User;
import coen241.calendarApp.model.EventTag;
import coen241.calendarApp.model.Event;
import coen241.calendarApp.service.EventService;
import coen241.calendarApp.service.EventTagService;
import coen241.calendarApp.service.RSVPService;
import coen241.calendarApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final EventTagService eventTagService;
    private final RSVPService rsvpService;
    private final UserService userService;
    @Autowired
    public EventController(EventService eventService, EventTagService eventTagService, RSVPService rsvpService, UserService userService) {
        this.eventService = eventService;
        this.eventTagService = eventTagService;
        this.rsvpService = rsvpService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Event> getAllEvents() {return eventService.getAllEvent();}

    @GetMapping("/{id}")
    public Event get(@PathVariable Long id) {
        Event event = eventService.getEvent(id);
        if (event == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return event;
    }
    @GetMapping("/{eventId}/rsvplist") //see which users are rsvp'ed for this event
    public List<User> getByRSVP(@PathVariable Long eventId) {
        Event event = eventService.getEvent(eventId);
        if (event == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND); //check eventId is valid

        List<RSVP> rsvps = rsvpService.getRSVPByEventId(eventId); //a list of rsvps with userIds

        List<User> users = new ArrayList<User>();
        for (RSVP rsvp : rsvps) {
            users.add(userService.getUserByUsername(rsvp.getUsername()));
        }
        return users;
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

    @GetMapping("/tag/{tag}")
    public List<Event> getByTag(@PathVariable String tag) {

        //TODO: check if tag is valid?

//        List<EventTag> eventtags = eventTagService.getEventTagByTag(tag); //a list of eventTags with eventIds
//
//        List<Event> events = new ArrayList<Event>();
//        for (EventTag eventtag : eventtags) {
//            events.add(eventService.getEvent(eventtag.getEventId()));
//        }
//        return events;
        List<Event> events = eventService.getEventsByTag(tag);
        if (events == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return events;
    }


    @GetMapping("/searchEvents")
    public List<Event> getByMultiParams(@RequestBody Map<String,List<String>> params){
        return eventService.getEventsByParams(params);
    }

    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
        return "Event Added Successfully.";
    }

}
