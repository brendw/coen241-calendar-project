package coen241.calendarApp.controller;

import coen241.calendarApp.model.Event;
import coen241.calendarApp.model.RSVP;
import coen241.calendarApp.model.User;
import coen241.calendarApp.service.EventService;
import coen241.calendarApp.service.RSVPService;
import coen241.calendarApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RSVPService rsvpService;
    private final EventService eventService;
    @Autowired
    public UserController(UserService userService, RSVPService rsvpService, EventService eventService) {
        this.userService = userService;
        this.rsvpService = rsvpService;
        this.eventService = eventService;
    }

    @GetMapping("/")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user;
    }
    @GetMapping("/{id}/rsvp")
    public List<Event> getRSVP(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND); //check id is valid

        List<RSVP> rsvps = rsvpService.getRSVPByUserId(id); //a list of rsvps with eventIds

        List<Event> events = new ArrayList<Event>() ;
        for (RSVP rsvp : rsvps) {
            events.add(eventService.getEvent(rsvp.getEventId()));
        }

        return events;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User Added Successfully.";
    }

    @PostMapping("/rsvp")
    public String addRSVP(@RequestBody RSVP rsvp) {
        rsvpService.saveRSVP(rsvp);
        return "RSVP Added Successfully.";
    }


}
