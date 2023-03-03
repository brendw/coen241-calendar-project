package coen241.calendarApp.service;

import coen241.calendarApp.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class CalendarTestService  {

    private final EventRepository calendarRepository;

    public CalendarTestService(EventRepository eventRepository) {
        this.calendarRepository = eventRepository;
    }

//    public Iterable<User> get() {
//        return calendarRepository.findAll();
//    }
//
//    public User get(Integer id) {
//        return calendarRepository.findById(id).orElse(null);
//    }
//
//    public User remove(Integer id) {
//        calendarRepository.deleteAllById(id);
//    }

}

