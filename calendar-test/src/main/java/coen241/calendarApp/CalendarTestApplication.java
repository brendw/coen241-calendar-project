package coen241.calendarApp;

import coen241.calendarApp.model.User;
import coen241.calendarApp.repository.UserRepository;
import coen241.calendarApp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalendarTestApplication {

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    EventRepository eventRepository;

    public static void main(String[] args) {

        SpringApplication.run(CalendarTestApplication.class, args);

    }


}
