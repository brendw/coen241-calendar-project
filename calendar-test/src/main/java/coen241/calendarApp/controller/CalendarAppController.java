package coen241.calendarApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CalendarAppController {

//    private final CalendarTestService calendarService;
//    @Autowired
//    public CalendarAppController(CalendarTestService calendarService) {
//        this.calendarService = calendarService;
//    }

    @GetMapping("/")
    public String hello() {
        return "Welcome to our project for COEN 241 Cloud Computing!";
    }

}

