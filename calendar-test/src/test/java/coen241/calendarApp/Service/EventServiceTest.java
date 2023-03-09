package coen241.calendarApp.Service;

import coen241.calendarApp.model.Event;
import coen241.calendarApp.repository.EventRepository;
import coen241.calendarApp.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class EventServiceTest {

    private final EventRepository eventRepository;
    @Autowired
    public EventServiceTest(EventRepository eventRepository) { this.eventRepository = eventRepository; }

    @Test
    public List<Event> getEventsByParamsMethod() {

        Map<String, List<String>> params = new HashMap<>();
        params.put("event_date", new ArrayList<>(Arrays.asList("2023-02-22")));
        params.put("location", new ArrayList<>(Arrays.asList("Clubs")));
        params.put("tag", new ArrayList<>());

        return eventRepository.findByEventDateAndLocationAndTag(params.get("event_date"), params.get("location"), params.get("tag"));
    }

}
