package coen241.calendarApp.controller;

import coen241.calendarApp.service.CalendarTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarTestController {

    private final CalendarTestService calendarService;
    public CalendarTestController(CalendarTestService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World ~";
    }

    @GetMapping("/hi")
    public String hi() {
        return "HI!!!!";
    }
}

